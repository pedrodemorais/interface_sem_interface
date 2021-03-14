package model.entities;

import java.util.Date;

public class AluguelDeCarros {
	private Carro carro;
	private Fatura fatura;
	
	private Date dataInicio;
	private Date dataFim;
	
	public AluguelDeCarros() {
		
	}

	public AluguelDeCarros(Carro carro, Date dataRetiradaCarro, Date dataEntregaCarro) {
		this.carro = carro;
		this.dataInicio = dataRetiradaCarro;
		this.dataFim = dataEntregaCarro;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public Date getDataRetiradaCarro() {
		return dataInicio;
	}

	public void setDataRetiradaCarro(Date dataRetiradaCarro) {
		this.dataInicio = dataRetiradaCarro;
	}

	public Date getDataEntregaCarro() {
		return dataFim;
	}

	public void setDataEntregaCarro(Date dataEntregaCarro) {
		this.dataFim = dataEntregaCarro;
	}
	
	
	
	

}
