package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Quarto número: ");
		int numero = sc.nextInt();
		System.out.print("Data entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data saída (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva: Data de saída deve ser posterior a data de entrada.");
		}
		else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Entre com a data atualizada da reserva:");

			System.out.print("Data entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data saída (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			String erro = reserva.atualizacaoDatas(entrada, saida);
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {	
				System.out.println("Reserva: " + reserva);
			}
		}
		sc.close();
		
	}
}
		

