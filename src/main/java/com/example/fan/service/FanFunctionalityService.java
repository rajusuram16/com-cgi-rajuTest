package com.example.fan.service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

@Service
public class FanFunctionalityService {

	
	private static  AtomicInteger speed = new AtomicInteger(0);
	private static  AtomicInteger reverseSpeed = new AtomicInteger(3);
//	private static  AtomicInteger reverseSpeed = new AtomicInteger(3);
	
	private static  AtomicReference<String> direction = new AtomicReference<String>("clock-wise");
	public AtomicInteger pull() {
		//System.out.println(speed);
		int existingValue = getValue();
        int newValue = existingValue + 1;
         
		//System.out.println(speed);
		if(newValue >3)
		{
			newValue = 0;
		}
		 speed.compareAndSet(existingValue, newValue);
		 //System.out.println(speed);
		 return speed;
	}
	
	
	public AtomicInteger reverse() {
		int existingValue = getValue();
		int newValue = -1;  
		
		switch(existingValue) {
		case 0:
			newValue = 3;
			break; 
		case 1:
			newValue = existingValue - 1;
			break;
		case 2:
			newValue = existingValue - 1;
			break;
		case 3:
			newValue = existingValue - 1;
			break;
	}
//		if(existingValue>0 && existingValue<3) {
//			newValue = existingValue - 1;
//		}
//		
//		else if(existingValue == 0) {
//			newValue = existingValue + 1;
//		}

		 speed.compareAndSet(existingValue, newValue);

		 return speed;
	}
	
//	public AtomicReference<String> reverse() {
//		String existingValue = getStringValue();
//		String newValue = null;
//		if(direction.get().equals("clock-wise")) {
//			newValue = "Anti clock-wise";
//			//direction.set("Anti clock-wise");
//		}
//		else if(direction.get().equals("Anti clock-wise")){
//			//direction.set("clock-wise");
//			newValue = "clock-wise";
//		}
//		direction.compareAndSet(existingValue, newValue);
//		return direction;
//	}
	 
	 public int getValue() {
	        return speed.get();
	    }
	
	 public String getStringValue() {
		 return direction.get();
	 }
	   
}
