package io.github.wesleyleocadio.arquiteturaspring.montadora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.github.wesleyleocadio.arquiteturaspring.montadora.model.Motor;
import io.github.wesleyleocadio.arquiteturaspring.montadora.model.enums.TipoMotor;

@Configuration
public class MontadoraConfiguration {
	
	@Bean
	@Primary
	public Motor motorAspirado() {
		var motor = new Motor();
		motor.setCavalos(120);
		motor.setCilindros(4);
		motor.setModelo("XPTO-0");
		motor.setLitragem(2.0);
		motor.setTipo(TipoMotor.ASPIRADO);
		return motor;
	}
	
	@Bean
	public Motor motorEletrico() {
		var motor = new Motor();
		motor.setCavalos(100);
		motor.setCilindros(3);
		motor.setModelo("TH-40");
		motor.setLitragem(1.6);
		motor.setTipo(TipoMotor.ELETRICO);
		return motor;
	}
	
	@Bean
	public Motor motorTurbo() {
		var motor = new Motor();
		motor.setCavalos(180);
		motor.setCilindros(4);
		motor.setModelo("XPTO-01");
		motor.setLitragem(1.5);
		motor.setTipo(TipoMotor.TURBO);
		return motor;
	}

}
