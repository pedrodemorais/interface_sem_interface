package model.services;

public class RegrasDoBrasil {
	
	public Double imposto(Double valor) {
		if(valor <=100) {
			return valor * 0.20;
			
		}else return valor * 0.15;
		
	}

}
