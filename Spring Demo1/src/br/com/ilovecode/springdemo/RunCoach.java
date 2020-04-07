package br.com.ilovecode.springdemo;

public class RunCoach implements Coach {

	@Override
	public String getDailyWorkout() {		
		return "Deu Certo";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
