package br.com.AtividadesResponsaveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AtividadesResponsaveis.entity.Atividades;


@Repository
public interface AtividadeRepository extends JpaRepository<Atividades, Integer>  {

}
