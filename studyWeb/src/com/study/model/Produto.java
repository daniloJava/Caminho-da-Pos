package com.study.model;

import java.io.Serializable;
import java.sql.Date;

public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421275730082267923L;

	private String codigoProduto;
	private String nome_produto;

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nome_produto;
	}

	public void setNomeProduto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

}
