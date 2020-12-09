package br.com.AtividadesResponsaveis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.AtividadesResponsaveis.entity.Responsavel;
import br.com.AtividadesResponsaveis.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	private final ResponsavelRepository responsavelRepository;
	
	@Autowired
	public ResponsavelService(ResponsavelRepository responsavelRepository) {
		this.responsavelRepository = responsavelRepository;
	}
	
	public Responsavel create(Responsavel responsavel) {
		Responsavel resp = responsavelRepository.save(responsavel);
		return resp;
	}
	
	public Page<Responsavel> findAll(Pageable pageable) {
		var page = responsavelRepository.findAll(pageable);
		return page;
	}

}
