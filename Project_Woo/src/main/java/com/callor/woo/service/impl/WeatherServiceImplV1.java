package com.callor.woo.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.woo.model.AddrDTO;
import com.callor.woo.model.AddrVO;
import com.callor.woo.model.WeatherDTO;
import com.callor.woo.service.WeatherService;

public class WeatherServiceImplV1 implements WeatherService {

	@Override
	public String queryURL(AddrVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeatherDTO> getAddrList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}


}
