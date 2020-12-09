package br.com.AtividadesResponsaveis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.AtividadesResponsaveis.entity.Atividades;
import br.com.AtividadesResponsaveis.entity.ResponsavelAtividade;
import br.com.AtividadesResponsaveis.service.AtividadeService;
import br.com.AtividadesResponsaveis.service.ResponsavelAtividadeService;

@RestController
@RequestMapping("/responsavelAtividade")
public class ResponsavelAtividadeController {
	
	
private final ResponsavelAtividadeService responsavelAtividadeService;
	
	@Autowired
	public ResponsavelAtividadeController(ResponsavelAtividadeService responsavelAtividadeService) {
		this.responsavelAtividadeService = responsavelAtividadeService;		
	}
	
	
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ResponsavelAtividade create (@RequestBody ResponsavelAtividade responsavelAtividade) {
		ResponsavelAtividade responsavelAtividades = responsavelAtividadeService.create(responsavelAtividade);
		return responsavelAtividades;
	}
	
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction){
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
		
		Page<ResponsavelAtividade> ResponsavelAtividade = responsavelAtividadeService.findAll(pageable);
		
		return new ResponseEntity<> (HttpStatus.OK);		
		
	}

}
