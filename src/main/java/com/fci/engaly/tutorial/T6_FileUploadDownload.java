package com.fci.engaly.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class T6_FileUploadDownload {

	/**
	 * steps => got postman => type url in url box field => choose post Http
	 * method => click body tab => and choose file will show record => type file
	 * (name that you defined in method MultipartFile file) and choose file you
	 * want => OK please if there any record in header tab delete it and let
	 * postman decide what will be
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam MultipartFile file) throws IOException {
		File copy = new File("/home/engaly/files/" + file.getOriginalFilename());
		copy.createNewFile();
		FileOutputStream stream = new FileOutputStream(copy);
		stream.write(file.getBytes());
		stream.close();
		return "File is upload successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
		// made file name is English to made server handle its name
		// please when you test this tutorial provide file with this name or you
		// can define custom file
		String fname = "learn childs.mp4";
		String filePath = "/home/engaly/files/" + fname;
		File file = new File(filePath);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.setContentType(MediaType.parseMediaType("application/txt"));
		headers.setContentLength(file.length());
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).body(resource);
		return responseEntity;
	}
}
