package com.callor.woo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.woo.model.AddrDTO;
import com.callor.woo.model.AddrVO;
import com.callor.woo.service.NaverService;
import com.callor.woo.service.WeatherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	@Qualifier("naverServiceV1")
	protected final NaverService nService;
	
	@Qualifier("weatherService")
	protected final WeatherService wService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String home(@RequestParam("lat") String latitude, @RequestParam("lng") String longitude) throws MalformedURLException, IOException, ParseException {
		
		log.debug("lat {}",latitude);
		log.debug("lng {}",longitude);
		
		String url = nService.queryURL(latitude, longitude);
		String jsonString = nService.getJsonString(url);
		List<AddrDTO> addrList = nService.getAddrList(jsonString);
		
		log.debug(addrList.toString());
		String addr = "";
		for(int i = 1; i < 4; i++) {
			addr += addrList.get(i).getName();
		}
		
		log.debug("String addr {}", addr.trim());
		
		List<AddrVO> location = nService.findByAddr(addr);
		
		log.debug("location {}",location);
		
		String queryURL = wService.queryURL(location);
		wService.getJsonString(queryURL);
		
		return "home";
	}
}
