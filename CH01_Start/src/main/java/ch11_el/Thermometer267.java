package ch11_el;

import java.util.HashMap;
import java.util.Map;

public class Thermometer267 {
	
	private Map<String,Double> locationEelsiusMP=new HashMap<String,Double>();
	
	private Double celsius;

	
	//instance method()사용하기 (EL)
	public Double getCelsius(String location) {
		return locationEelsiusMP.get(location);
	}

	public void setCelsius(String location, Double value) {
		this.locationEelsiusMP.put( location, value);
	}
	
	public Double getFahrenheit(String location) {
		Double celsius=getCelsius(location);
		if(celsius==null) {
			return celsius;	
		} 
		return celsius.doubleValue()*1.8+32.0;
	}
	
	public String getInfo() {
		return "온도계 변화기 1.1";
	}
	//getinfo라는 메소드를 el표기로 사용기 ${info}로 표기해야함. get,set의 경우에만 소문자로 변형함
	
	
}
