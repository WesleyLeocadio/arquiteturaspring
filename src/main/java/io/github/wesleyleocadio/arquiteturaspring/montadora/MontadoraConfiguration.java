package io.github.wesleyleocadio.arquiteturaspring.montadora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.wesleyleocadio.arquiteturaspring.model.Motor;
import io.github.wesleyleocadio.arquiteturaspring.model.enums.TipoMotor;

@Configuration
public class MontadoraConfiguration {
	
	@Bean
	public Motor motor() {
		var motor = new Motor();
		motor.setCavalos(120);
		motor.setCilindros(4);
		motor.setModelo("XPTO-0");
		motor.setLitragem(2.0);
		motor.setTipo(TipoMotor.ASPIRADO);
		return motor;
	}

}
