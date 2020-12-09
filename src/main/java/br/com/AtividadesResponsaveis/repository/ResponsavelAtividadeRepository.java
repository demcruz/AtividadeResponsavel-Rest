package br.com.AtividadesResponsaveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AtividadesResponsaveis.entity.ResponsavelAtividade;

@Repository
public interface ResponsavelAtividadeRepository extends JpaRepository<ResponsavelAtividade, Long> {

}
