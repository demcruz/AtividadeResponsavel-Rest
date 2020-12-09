package br.com.AtividadesResponsaveis.entity;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
@Table(name="TB_MGD_Responsavel")
public class Responsavel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989667597067833935L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Responsavel")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_Pessoa")
	private Pessoa pessoa;
	
	@Column(name="TX_Email")
	private String email;
	
//	//Responsavel para muitas atividades 
//	@OneToMany(fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	@JoinColumn(name = "ID_Responsavel")
//	private Set<ResponsavelAtividade> respAtividades;

}
