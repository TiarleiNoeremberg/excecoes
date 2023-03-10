package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ExcecaoDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		if (!saida.after(entrada)){
			throw new ExcecaoDominio("Data de saída deve ser posterior a data de entrada.");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date entrada, Date saida) {
		
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			throw new ExcecaoDominio("Data da reserva, para atualização, deve ser data futura.");
		}
		if (!saida.after(entrada)){
			throw new ExcecaoDominio("Data de saída deve ser posterior a data de entrada.");
		}
		
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto ");
		sb.append(numeroQuarto);
		sb.append(", entrada: ");
		sb.append(sdf.format(entrada));
		sb.append(", saída: ");
		sb.append(sdf.format(saida));
		sb.append(", ");
		sb.append(duracao());
		sb.append(" noites.");
		return sb.toString();
	}
	
}
