package br.com.AtividadesResponsaveis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.AtividadesResponsaveis.entity.Pessoa;
import br.com.AtividadesResponsaveis.repository.PessoaRepository;

@Service
public class PessoaService {
	
private final PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public Pessoa create(Pessoa pessoa) {
		Pessoa pess = pessoaRepository.save(pessoa);
		return pess;
	}
	
	public Page<Pessoa> findAll(Pageable pageable) {
		var page = pessoaRepository.findAll(pageable);
		return page;
	}

}
