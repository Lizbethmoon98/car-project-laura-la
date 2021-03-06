package tech.tarragona.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.tarragona.spring.model.Coche;
import tech.tarragona.spring.repository.CocheRepository;

@Service
public class CocheService {
	@Autowired
	CocheRepository cocheRepository;
	
	@Transactional
	public List <Coche> listarCoches(){
		return cocheRepository.findAll();
	
	}
	
	@Transactional
	public Coche crearCoche(Coche coche) {
		return cocheRepository.save(coche);
		
	}
}
