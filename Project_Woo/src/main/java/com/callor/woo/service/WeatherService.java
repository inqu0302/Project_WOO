package com.callor.woo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.woo.model.AddrVO;
import com.callor.woo.model.WeatherDTO;

public interface WeatherService {
	
	public String queryURL(AddrVO vo);

	public String getJsonString(String queryURL) throws MalformedURLException, IOException;
	
	public List<WeatherDTO> getAddrList(String jsonString) throws ParseException;
	
}
