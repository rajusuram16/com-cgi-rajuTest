package com.example.fan.service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fan.service.FanFunctionalityService;

@Service
public class FanFunctionality {
	
	@Autowired
	FanFunctionalityService fanService ;
	
	public  String fanSpeed() {
		
		AtomicInteger s = fanService.pull();
		String speed = null;
		
		switch(s.intValue()) {
			case 0:
				speed = "fan is off";
				break; 
			case 1:
				speed = "fan is in low speed";
				break;
			case 2:
				speed =  "fan is in Medium speed";
				break;
			case 3:
				speed = "fan is in High speed";
				break;
		}
			return speed;
	}
	
	public  String fanReverseSpeed() {
		
		AtomicInteger s = fanService.reverse();
		String speed = null;
		
		switch(s.intValue()) {
			case 0: 
				speed = "fan is off";
				break;
			case 1:
				speed = "fan is in low speed";
				break;
			case 2: 
				speed =  "fan is in Medium speed";
				break;
			case 3:
				speed = "fan is in High speed";
				break;
		}
			return speed;
	}
	
//	public  String fanDirection() {
//		AtomicReference<String> direction = fanService.reverse();
//		
//		return "fan is rotating in " +  direction.toString() + " direction.";
//		
//	}
}
