package br.com.eicon.leonardo.eicon.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "cliente", schema = "eicon")
@Data
public class Cliente {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(
			  value = "Id",
			  name = "id",
			  dataType = "String",
			  hidden = true)
	private Long id;
	
	@Column(name="nr_controle")
	private Long numeroControle;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="vl_unitario")
	private BigDecimal valorUnitario;

	@Column(name="nr_qtd")
	private Long quantidade;
	
	@ApiModelProperty(
			  value = "Data",
			  name = "dataCadastro",
			  dataType = "String",
			  required = false,
			  hidden = true)
	@Column(name="dt_cadastro")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		dataCadastro = LocalDate.now();

	}
	
}
