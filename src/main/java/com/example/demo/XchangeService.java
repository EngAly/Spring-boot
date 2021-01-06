package com.example.demo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class XchangeService {

	ObjectMapper mapper = new ObjectMapper();

//	public Xchange getCurrencies() {
//		return getCurrenciesFromApi();
//	}

//	private Xchange getCurrenciesFromApi() {
//		try {
//			String url_str = "https://v6.exchangerate-api.com/v6/0bf3e0ad697b6fd253869be8/latest/USD";
//			URL url = new URL(url_str);
//			HttpURLConnection request = (HttpURLConnection) url.openConnection();
//			request.connect();
//
//			Xchange xchange = mapper.readValue(request.getContent().toString().getBytes(), Xchange.class);
//
//			return xchange;
//
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
	
	
	public Xchange getCurrencies() {
		try {
			String url_str = "https://v6.exchangerate-api.com/v6/0bf3e0ad697b6fd253869be8/latest/USD";
			URL url = new URL(url_str);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();
			
//			new InputStreamReader((InputStream) request.getContent()).;
			
			return  mapper.readValue((InputStream) request.getContent(), Xchange.class);
			
			
 		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
