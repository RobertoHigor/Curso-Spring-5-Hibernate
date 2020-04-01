package br.com.ilovecode.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoje é seu dia de sorte";
	}

}
