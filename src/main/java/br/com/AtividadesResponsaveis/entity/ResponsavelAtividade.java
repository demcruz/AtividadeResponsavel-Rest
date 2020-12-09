package br.com.AtividadesResponsaveis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_MGD_Atividade_Has_Responsavel")
public class ResponsavelAtividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -362794772971822458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Atividade_Has_Responsavel")
	private Integer id;
//
//	@ManyToOne
//	@JoinColumn(name = "ID_Atividade")
//	private Atividades atividade;
// 
//	@ManyToOne
//	@JoinColumn(name = "ID_Responsavel")
//	private Responsavel responsavel;
	


	






}
