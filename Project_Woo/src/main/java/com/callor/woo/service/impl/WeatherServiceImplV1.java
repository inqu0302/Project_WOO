package com.callor.woo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.woo.config.WeatherSecret;
import com.callor.woo.model.AddrVO;
import com.callor.woo.model.WeatherDTO;
import com.callor.woo.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("weaherService")
public class WeatherServiceImplV1 implements WeatherService {

	@Override
	public String queryURL(List<AddrVO> location) {
		// TODO Auto-generated method stub
		String ar_x = location.get(0).getAr_x();
		String ar_y = location.get(0).getAr_y();
		
		
		
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(WeatherSecret.URL);
		
		String queryString = String.format("?serviceKey=%s&numOfRows=10&pageNo=10&dataType=JSON"
				+ "&base_date=20210708&base_time=0500&nx=%s&ny=%s", WeatherSecret.KEY, ar_x, ar_y);
		
		queryURL.append(queryString);
		
		log.debug("queryURL {}",queryURL.toString());
		return queryURL.toString();
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		URL url = new URL(queryURL);
		
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		httpConn.setRequestMethod("GET");
		
		int httpStatusCode = httpConn.getResponseCode();
		
		BufferedReader buffer = null;
		InputStreamReader is = null;
		
		if(httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			is = new InputStreamReader(httpConn.getErrorStream());
		}
		
		buffer = new BufferedReader(is);
		
		StringBuffer sBuffer = new StringBuffer();
		
		while(true) {
			String reader = buffer.readLine();
			if(reader == null) {
				break;
			}
			sBuffer.append(reader);
		}
		log.debug("날씨 응답 결과 {}",sBuffer.toString());
		
		return null;
	}

	@Override
	public List<WeatherDTO> getAddrList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
