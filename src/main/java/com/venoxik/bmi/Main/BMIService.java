package com.venoxik.bmi.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository 
public class BMIService {

	public static List<String> genderType = new ArrayList<String>();
	public static Map<Integer, User> userList = new HashMap<>();
	private static int userId = 1000;

	
	public BMIService() {
		genderType.add("Male");
		genderType.add("Female");
		genderType.add("Others");
	}

	public User addUserDetails(User user) {
		user.setUserId(++userId); 
		userList.put(userId, user); 
		return user; 
	}

	public double calculateBMI(User user) {

		int height = user.getHeight();
		double weight = user.getWeight();

		return Math.ceil((100 * 100 * weight) / (height * height));
	}

	public String getBMIStatus(double bmi) {

		if (bmi < 18.5)
			return "underweight";

		if (bmi < 25)
			return "normal";

		if (bmi <= 30)
			return "overweight";

		return "obese";
	}

}