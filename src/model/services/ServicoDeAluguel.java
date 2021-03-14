package model.services;

import model.entities.AluguelDeCarros;
import model.entities.Fatura;


//ATENCAO!!!!!!!!!!!!! AQUI SE INICIA A CLASSE SERVIÇOOOOOOOOOO
public class ServicoDeAluguel {
	
	private Double precoPorHora;
	private Double precoPorDia;
	//regras do Brasil está estanciado aqui para calcular as taxas de imposto de acordo com as regras do Brasil
	private RegrasDoBrasil regrasDoBrasil;//
	

	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, RegrasDoBrasil regrasDoBrasil) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.regrasDoBrasil = regrasDoBrasil;
	}


	
	public void processarFatura(AluguelDeCarros aluguelDeCarros) {
		// para processar a fatura precisa achar a diferença de tempo da entrega
		
		Long t1 = aluguelDeCarros.getDataEntregaCarro().getTime();
		Long t2 = aluguelDeCarros.getDataRetiradaCarro().getTime();
		//aqui achou a diferença e converteu para horas
		double horas = (double)(t1-t2)/1000/60/60;
		
		//aqui está achando o valor sem os impostos
		double valorSemImposto;
		if(horas < 12) {
			 valorSemImposto = Math.ceil(horas) * precoPorHora;
					
		}else { 
			 valorSemImposto = Math.ceil(horas/24) * precoPorDia;
		}
		
		//aqui usa a variavel imposto para passar o valor sem imposto para a regra do brasil e retornar o imposto calculado;
		double imposto = regrasDoBrasil.imposto(valorSemImposto);
		
		
		aluguelDeCarros.setFatura(new Fatura(valorSemImposto, imposto));
		
		
	}
	
	

}
