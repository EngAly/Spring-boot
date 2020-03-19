package com.fci.engaly.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtile {

	String SECRETKEY = "secret";

	/**
	 * get user name from token
	 * 
	 * @param token
	 * @return
	 */
	public String extractUserName(String token) {
		return extractCalim(token, Claims::getSubject);
	}

	/**
	 * get expire date (i.e when the token will be die)
	 * 
	 * @param token
	 * @return
	 */
	public Date extractExpiration(String token) {
		return extractCalim(token, Claims::getExpiration);
	}

	public <T> T extractCalim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllCalims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * test id token is expired or not
	 * 
	 * @param token
	 * @return
	 */
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * Claims live in the Body of JWT<br>
	 * notes:- there two types of Claims<br>
	 * 1) Reserved Claims => built in claims that is native with JWT API.<br>
	 * 2) Custom Claims => Custom claims are custom key-value pairs that you can add
	 * to the body of JWT.<br>
	 * 
	 * @param token => token created from claims(either specific or custom)
	 * @return => getBody() that have all Claims .getSubject() "native" and other
	 *         custom claims .get("Role").
	 */
	private Claims extractAllCalims(String token) {
		return Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
	}

	/**
	 * generate token using subject(i.e username) and claims
	 * 
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return createToken(claims, userDetails.getUsername());

	}

	/**
	 * <div style="background-color:black;color:white;"> To generate a new JWT will
	 * use the Jwts.builder()<br>
	 * subject --> which is a value that identifies the principal user.<br>
	 * This value can be a user ID or userName for which this JWT was generated<br>
	 * .setSubject(subject) "reserved" <br>
	 * .setExpiration(expDate) "reserved" <br>
	 * .claim("Role", "Admin") "custom" <br>
	 * .claim("Department", "Product development")"custom" <br>
	 * .signWith(SignatureAlgorithm.HS512, secret ) "reserved" <br>
	 * notes :-<br>
	 * Just remember not to add sensitive information like a user password or token
	 * secret. JWT claims can be decoded and viewed.
	 * 
	 * @param claims  => set claims as Map key-value "it custom claims
	 * @param subject => user name
	 * @return : created token
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		long date = System.currentTimeMillis();
		return Jwts.builder() //
				.setClaims(claims) //
				.setSubject(subject) //
				.setIssuedAt(new Date(date)) // start date
				.setExpiration(new Date(date + 1000 * 60 * 10)) // value when the JWT should expire
//				  secret key which is usually a unique alpha-numeric and should be kept private.
				.signWith(SignatureAlgorithm.HS256, SECRETKEY) //
				.compact();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
