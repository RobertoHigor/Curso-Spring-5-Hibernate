package br.com.ilovecode.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	// Criar um construtor sem argumento
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String email) {
		System.out.println("CricketCoach: inside setter for email");
		this.emailAddress = email;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter for team");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	@Override
	public String getDailyWorkout() {		
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	

}
