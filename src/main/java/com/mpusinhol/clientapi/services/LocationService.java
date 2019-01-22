package com.mpusinhol.clientapi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.mpusinhol.clientapi.domain.Location;

@Service
public class LocationService {
	
	private static final String LOCATOR_API_URL = "https://www.ipvigilante.com/";

	public Location FindLocationByIp(String ip) throws IOException {
		URL url = new URL(LOCATOR_API_URL + "179.98.28.139");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "request");
		
		Integer responseCode = conn.getResponseCode();

		if (responseCode != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + responseCode);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;

		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		System.out.println(output);

		conn.disconnect();
		
		return new Location();
	}
}
