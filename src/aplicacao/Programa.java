package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Quarto número: ");
			int numero = sc.nextInt();
			System.out.print("Data entrada (dd/MM/yyyy): ");
			Date entrada = sdf.parse(sc.next());
			System.out.print("Data saída (dd/MM/yyyy): ");
			Date saida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data atualizada da reserva:");
			System.out.print("Data entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data saída (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(entrada, saida);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválida.");
		}
		catch (ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado! Digite um número de quarto válido.");
		}
				
		sc.close();
		
	}
}
		

