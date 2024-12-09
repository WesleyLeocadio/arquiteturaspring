package io.github.wesleyleocadio.arquiteturaspring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.wesleyleocadio.arquiteturaspring.model.Chave;
import io.github.wesleyleocadio.arquiteturaspring.model.HonraHRV;
import io.github.wesleyleocadio.arquiteturaspring.model.Motor;
import io.github.wesleyleocadio.arquiteturaspring.model.records.CarroStatusRecord;

@RestController
public class TesteFabricaRepositorie {
	
	@Autowired
	private Motor motor;
	
	public CarroStatusRecord ligarCarro(@RequestBody Chave chave) {
		var carro = new HonraHRV(motor);
		return carro.darIngnicao(chave);
	}
}
