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

import br.com.AtividadesResponsaveis.entity.Responsavel;
import br.com.AtividadesResponsaveis.service.ResponsavelService;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

	private final ResponsavelService responsavelService;

	@Autowired
	public ResponsavelController(ResponsavelService responsavelService) {
		this.responsavelService = responsavelService;
	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public Responsavel create(@RequestBody Responsavel responsavel) {
		Responsavel responsaveis = responsavelService.create(responsavel);
		return responsaveis;
	}

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;

		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));

		Page<Responsavel> responsaveis = responsavelService.findAll(pageable);

		return new ResponseEntity<>(responsaveis, HttpStatus.OK);

	}

}
