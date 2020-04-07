package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
	FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim Coach: " + email + " " + team;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
