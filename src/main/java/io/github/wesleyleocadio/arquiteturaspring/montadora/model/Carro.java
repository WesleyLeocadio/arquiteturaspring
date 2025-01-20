package io.github.wesleyleocadio.arquiteturaspring.montadora.model;

import java.awt.Color;

import io.github.wesleyleocadio.arquiteturaspring.montadora.model.enums.Montadora;
import io.github.wesleyleocadio.arquiteturaspring.montadora.model.records.CarroStatusRecord;

public class Carro {
	private String modelo;
	private Color cor;
	private Motor motor;
	private Montadora montadora;
	
	public Carro(Motor motor) {
		this.motor = motor;
	}
	
	
	public CarroStatusRecord darIngnicao(Chave chave) {
		if (chave.getMontadora() != this.montadora) {
			return new CarroStatusRecord("Nao é possivel ligar o carro com esta chave");
		}
		return new CarroStatusRecord("Carro ligado! Rodando com o motor: "+ this.motor);
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public Montadora getMontadora() {
		return montadora;
	}
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
}
