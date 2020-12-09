package br.com.AtividadesResponsaveis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.AtividadesResponsaveis.entity.ResponsavelAtividade;
import br.com.AtividadesResponsaveis.repository.ResponsavelAtividadeRepository;

@Service
public class ResponsavelAtividadeService {
	
private final ResponsavelAtividadeRepository responsavelAtividadeRepository;
	
	@Autowired
	public ResponsavelAtividadeService(ResponsavelAtividadeRepository responsavelAtividadeRepository) {
		this.responsavelAtividadeRepository = responsavelAtividadeRepository;
	}
	
	public ResponsavelAtividade create(ResponsavelAtividade responsavelAtividade) {
		ResponsavelAtividade respAtivd = responsavelAtividadeRepository.save(responsavelAtividade);
		return respAtivd;
	}
	
	public Page<ResponsavelAtividade> findAll(Pageable pageable) {
		var page = responsavelAtividadeRepository.findAll(pageable);
		return page;
	}

}
