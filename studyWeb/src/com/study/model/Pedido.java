package com.study.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7093168259010126550L;
	
	
	private Integer numeroPedido;
	private Date DataPedido;

	public Date getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		DataPedido = dataPedido;
	}

	private Cliente cliente;
	private ItemPedido itemPedido;
	private List<ItemPedido> itemPedidoLista;

	public List<ItemPedido> getItemPedidoLista() {
		return itemPedidoLista;
	}

	public void setItemPedidoLista(List<ItemPedido> itemPedidoLista) {
		this.itemPedidoLista = itemPedidoLista;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

}
