package br.com.AtividadesResponsaveis.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_MEG_Pessoa")
public class Pessoa  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465540541633415824L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pessoa")
	private Long id;

	@Column(name = "NM_Pessoa")
	private String nome;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "DT_Nascimento", nullable = false)
	private Date dataNascimento;

	@Column(name = "CD_Documento_Identificacao")
	private String documentoIdentificacao;


	@Column(name = "NM_Pessoa_Busca")
	private String nomeBusca;

}
