package com.example.fan.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fan.service.FanFunctionality;

@RestController
@RequestMapping("/speed")
public class FanController {
	
	@Autowired
	private FanFunctionality fanFunctionality;
	
	@GetMapping("/fan/{direction}")
	public String getFanSpeed(@PathVariable("direction") String direction) {
//		System.out.println("test");
		String speed = null; 
		if(direction.equalsIgnoreCase("forward")) { 
			speed = fanFunctionality.fanSpeed();
			
		}
		else if(direction.equalsIgnoreCase("reverse")) {
			speed = fanFunctionality.fanReverseSpeed();
			
		}
		else {
			speed =  "give correct direction. Only forward and reverse are accepted as path params"
					+"sample: http://localhost:8080/speed/fan/forward or http://localhost:8080/speed/fan/reverse";
		}

		return speed;
	}

}
