package com.callor.woo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.callor.woo.service.TimeService;

@Service("timeService")
public class TimeServiceImplV1 implements TimeService {

	@Override
	public String time() {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		
		SimpleDateFormat tm = new SimpleDateFormat("HH");
		
		Integer intTime = Integer.valueOf(tm.format(date));
		
		String time = null;
		
		if( 0 <= intTime && 300 < intTime) time="0000";
		else if( 300 <= intTime && 600 < intTime) time="0300";
		else if( 600 <= intTime && 900 < intTime) time="0600";
		else if( 900 <= intTime && 1200 < intTime) time="0900";
		else if( 1200 <= intTime && 1500 < intTime) time="1200";
		else if( 1500 <= intTime && 1800 < intTime) time="1500";
		else if( 1800 <= intTime && 2100 < intTime) time="1800";
		else if( 2100 <= intTime && 2400 < intTime) time="2100";
		
		return time;
	}

}
