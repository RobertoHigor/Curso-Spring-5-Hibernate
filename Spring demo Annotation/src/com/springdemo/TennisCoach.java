package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach:dentro do construtor padrão");
	}
	
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: Executando setFortuneService");
		fortuneService = theFortuneService;
			}
	
	@Autowired
	public void doCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: Executando doCrazyStuff");
		fortuneService = theFortuneService;
	}*/
	
	// Spring irá procurar um componente que implementa essa interface
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
