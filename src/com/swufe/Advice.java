package com.swufe;

public class Advice {
	public float showBmi (String height,String weight) {
		Float h=Float.parseFloat(height);
		Float w=Float.parseFloat(weight);
		float bmi=w/(h*h);
		return bmi;
	}
}
