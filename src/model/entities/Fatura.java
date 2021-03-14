package model.entities;

public class Fatura {
	private double valorSemImposto;
	private double imposto;
	
	
	public Fatura() {
		
	}
	
	public Fatura(double valorSemImposto, double imposto) {
		this.valorSemImposto = valorSemImposto;
		this.imposto = imposto;
	}
	
	public double getValorSemImposto() {
		return valorSemImposto;
	}

	public void setValorSemImposto(double valorSemImposto) {
		this.valorSemImposto = valorSemImposto;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getValorAPagar() {
		return getImposto() + getValorSemImposto();
		
		
		
	}

}
