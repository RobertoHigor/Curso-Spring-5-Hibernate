package br.com.ilovecode.springdemo;

public class BaseballCoach implements Coach{
	// Definir um campo privado para a dependência
	private FortuneService fortuneService;
	
	// Definir um construtor para a injeção de dependência
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// Utilizar fortuneService
		return fortuneService.getFortune();
	}
}
