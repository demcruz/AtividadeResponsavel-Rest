package br.com.AtividadesResponsaveis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.AtividadesResponsaveis.entity.Atividades;
import br.com.AtividadesResponsaveis.repository.AtividadeRepository;




@Service
public class AtividadeService {
	

	private final AtividadeRepository atividadeRepository;
	
	@Autowired
	public AtividadeService(AtividadeRepository atividadeRepository) {
		this.atividadeRepository = atividadeRepository;
	}
	
	public Atividades create(Atividades atividade) {
		Atividades ativd = atividadeRepository.save(atividade);
		return ativd;
	}
	
	public Page<Atividades> findAll(Pageable pageable) {
		var page = atividadeRepository.findAll(pageable);
		return page;
	}

	

	

	

}
