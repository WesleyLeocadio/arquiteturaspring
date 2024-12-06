package io.github.wesleyleocadio.arquiteturaspring.model;

import java.awt.Color;

import io.github.wesleyleocadio.arquiteturaspring.model.enums.Montadora;

public class HonraHRV extends Carro {
	public HonraHRV(Motor motor) {
		super(motor);
		setModelo("HRV");
		setCor(Color.BLACK);
		setMontadora(Montadora.HONDA);
	}
}
