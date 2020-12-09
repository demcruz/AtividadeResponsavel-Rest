package br.com.AtividadesResponsaveis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of="id")
@Entity
@Table(name = "TB_MGD_Atividade")
public class Atividades implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -2243456996155833544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Atividade")
	private Integer id;

	@Column(name = "NM_Atividade")
	private String nome;

	@Column(name = "TX_Descricao")
	private String descricao;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "DT_Inicio", nullable = false)	
	private Date dataInicio;

	@Column(name = "DT_Termino", nullable = false)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dataTermino;

	@Column(name = "PE_Concluido")
	private Integer percentualConcluido;

	@Column(name = "QT_Horas_Esforco")
	private Integer horasEsforco;

//	@ManyToOne
//	@JoinColumn(name = "ID_Responsavel")
//	private Responsavel responsavel;

//	uma atividade para muitos responsaveis
//	  @ManyToMany
//	  @JoinTable(name="TB_MGD_Atividade_Has_Responsavel", joinColumns=
//	            {@JoinColumn(name="ID_Atividade")}, inverseJoinColumns=
//	            {@JoinColumn(name="ID_Responsavel")})
//	private List<Responsavel> responsaveis;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="TB_MGD_Atividade_Has_Responsavel")
	private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

	@Column(name = "NR_Atividade")
	private Integer numeroAtividade;

	@Column(name = "QT_Dias")
	private Integer quantidadeDias;
}
