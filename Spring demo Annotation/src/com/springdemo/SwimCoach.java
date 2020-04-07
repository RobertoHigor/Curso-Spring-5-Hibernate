package com.springdemo;

public class SwimCoach implements Coach{
	FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim Coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
