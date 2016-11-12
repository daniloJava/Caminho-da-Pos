package com.study.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.study.dao.IClienteDao;
import com.study.dao.IItemPedidoDao;
import com.study.dao.jdbc.ClienteDao;
import com.study.dao.jdbc.ConnectionFactory;
import com.study.dao.jdbc.ItemPedidoDao;
import com.study.model.Cliente;
import com.study.model.ItemPedido;

@Path("/itemPedido")
public class ItemPedidoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public ItemPedido get(@PathParam("id") int id){
		
		ItemPedido itemPedido = new ItemPedido();
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IItemPedidoDao dao = new ItemPedidoDao(conn);
			itemPedido = dao.get(id);
			System.out.println(itemPedido.getPedido() + "Recuperado");
		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		
		return itemPedido;
	}
	
	/**Requisição do Post 
	 * para fazer um insart 
	 * 
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String POST(ItemPedido itemPedido){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IItemPedidoDao dao = new ItemPedidoDao(conn);
			dao.insert(itemPedido);
			System.out.println(itemPedido.getPedido() + "Inserido");

		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		System.out.println(itemPedido.getPedido());
		return "1";
	}
	
	/**Put para somente colocar um Update
	 * 
	 * @param itemPedido
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public ItemPedido PUT(ItemPedido itemPedido){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IItemPedidoDao dao = new ItemPedidoDao(conn);
			dao.update(itemPedido);
			System.out.println(itemPedido.getPedido() + "Atualizado");

		} catch (Exception e) {
			System.out.println("Problemas para update " + e.getMessage());
		}
		return itemPedido;
	}
	
	/**Delete Usando um Objeto
	 * 
	 * @param itemPedido
	 * @return
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String DELETE(ItemPedido itemPedido) {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IItemPedidoDao dao = new ItemPedidoDao(conn);
			dao.delete(itemPedido);
			System.out.println(itemPedido.getPedido()+ "DELETADO");

		} catch (Exception e) {
			System.out.println("Problemas para deletar " + e.getMessage());

		}

		return "{\"msg\" : \" CLiente exlcuido com sucesso.\"}";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemPedido> list(){
		List<ItemPedido> list = new ArrayList<ItemPedido>();
		try{ 
		Connection conn = new ConnectionFactory().getConnection();
		IItemPedidoDao dao = new ItemPedidoDao(conn);
		list = dao.listAll();
		
		} catch (Exception e) {						
			System.out.println("Problemas para Listar todos " + e.getMessage());
		}
		return list;
	}
	
}
