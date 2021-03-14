package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Carro;
import model.entities.AluguelDeCarros;
import model.services.RegrasDoBrasil;
import model.services.ServicoDeAluguel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados da Locação: ");
		
		System.out.print("Modelo do Carro: ");
		String modeloCarro = sc.nextLine();
		
		System.out.print("Data e Hora da Retirada do Carro: (dd/MM/yyyy hh:mm) ");
		Date dataInicio = sdf.parse(sc.nextLine());
	
		System.out.print("Data e Hora da Devolução do Carro : (dd/MM/yyyy hh:mm) ");
		Date dataFim = sdf.parse(sc.nextLine());
		
		AluguelDeCarros aluguelDeCarros = new AluguelDeCarros(new Carro(modeloCarro), dataInicio, dataFim);
		
		System.out.print("Preco por Hora: ");
		Double precoPorHora = sc.nextDouble();
		
		System.out.print("Preco por Dia: ");
		Double precoPorDia = sc.nextDouble();
		
		//ATENÇÃO --- AQUI ENTRA O PACOTE SERVIÇO
		//populando a classe serviço com os dados necessários para o metodo calcular e processar a fatura
		ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorHora, precoPorDia, new RegrasDoBrasil());
		//
		servicoDeAluguel.processarFatura(aluguelDeCarros);
		
		System.out.println("Fatura da Locação: ");
		System.out.println("Pagamento sem Imposto: "+String.format("%.2f",aluguelDeCarros.getFatura().getValorSemImposto()));
		System.out.println("Imposto: "+String.format("%.2f",aluguelDeCarros.getFatura().getImposto()));
		System.out.println("Total: "+String.format("%.2f",aluguelDeCarros.getFatura().getValorAPagar()));
		
		
		
		
		

	}

}
