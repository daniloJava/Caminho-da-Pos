package com.study.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**Anotadando a classe com 
 * @XmlRootElement -e onde o JAX-RS, entende o Jersey
 * com o RestFul
 * 
 * @author tapower
 *
 */
@XmlRootElement
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5031465574391263067L;
	
	
	private Integer codigo;
	private String nome;
	private String inscricaoFederal;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInscricaoFederal() {
		return inscricaoFederal;
	}
	public void setInscricaoFederal(String inscricaoFederal) {
		this.inscricaoFederal = inscricaoFederal;
	}
	
	
}
