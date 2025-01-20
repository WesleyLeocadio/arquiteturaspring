package io.github.wesleyleocadio.arquiteturaspring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wesleyleocadio.arquiteturaspring.montadora.model.Chave;
import io.github.wesleyleocadio.arquiteturaspring.montadora.model.HonraHRV;
import io.github.wesleyleocadio.arquiteturaspring.montadora.model.Motor;
import io.github.wesleyleocadio.arquiteturaspring.montadora.model.records.CarroStatusRecord;

@RestController
@RequestMapping("/carros")
public class TesteFabricaRepositorie {
	
	@Autowired
	@Qualifier("motorEletrico")
	private Motor motor;
	
	@PostMapping
	public CarroStatusRecord ligarCarro(@RequestBody Chave chave) {
		var carro = new HonraHRV(motor);
		return carro.darIngnicao(chave);
	}
}
