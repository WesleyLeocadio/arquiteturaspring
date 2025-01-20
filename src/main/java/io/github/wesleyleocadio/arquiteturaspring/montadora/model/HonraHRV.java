package io.github.wesleyleocadio.arquiteturaspring.montadora.model;

import java.awt.Color;

import io.github.wesleyleocadio.arquiteturaspring.montadora.model.enums.Montadora;

public class HonraHRV extends Carro {
	public HonraHRV(Motor motor) {
		super(motor);
		setModelo("HRV");
		setCor(Color.BLACK);
		setMontadora(Montadora.HONDA);
	}
}
