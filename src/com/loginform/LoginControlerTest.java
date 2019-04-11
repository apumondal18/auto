package com.loginform;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.ws.Response;

import org.junit.jupiter.api.Test;

class LoginControlerTest {

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws IOException {
		URL url = new URL("http://www.google.com");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		assertEquals(200,httpCon.getResponseCode());
		    
		
		
	}

	

}
