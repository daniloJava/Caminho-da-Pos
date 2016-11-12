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

import com.study.dao.IPedidoDao;
import com.study.dao.IProdutoDao;
import com.study.dao.jdbc.ConnectionFactory;
import com.study.dao.jdbc.PedidoDao;
import com.study.dao.jdbc.ProdutoDao;
import com.study.model.Pedido;
import com.study.model.Produto;

@Path("/pedido")
public class PedidoResource {

	/**Requisição via GEt somente
	 * 
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Pedido get(@PathParam("id") int id){
		Pedido oedido = new Pedido();
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IPedidoDao dao = new PedidoDao(conn);
			oedido = dao.get(id);
			System.out.println(oedido.getNumeroPedido() + "Recuperado");
		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		
		return oedido;
	}
	
	/**Requisição do Post 
	 * para fazer um insart 
	 * 
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String POST(Pedido pedido){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IPedidoDao dao = new PedidoDao(conn);
			dao.insert(pedido);
			System.out.println(pedido.getNumeroPedido() + "Inserido");

		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		System.out.println(pedido.getNumeroPedido());
		return "1";
	}
	
	/**Put para somente colocar um Update
	 * 
	 * @param pedido
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Pedido PUT(Pedido pedido){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IPedidoDao dao = new PedidoDao(conn);
			dao.update(pedido);
			System.out.println(pedido.getNumeroPedido() + "Atualizado");

		} catch (Exception e) {
			System.out.println("Problemas para update " + e.getMessage());
		}
		return pedido;
	}
	
	/**Delete Usando um Objeto
	 * 
	 * @param pedido
	 * @return
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String DELETE(Pedido pedido) {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IPedidoDao dao = new PedidoDao(conn);
			dao.delete(pedido);
			System.out.println(pedido.getNumeroPedido() + "DELETADO");

		} catch (Exception e) {
			System.out.println("Problemas para deletar " + e.getMessage());

		}

		return "{\"msg\" : \" CLiente exlcuido com sucesso.\"}";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> list(){
		List<Pedido> list = new ArrayList<Pedido>();
		try{ 
		Connection conn = new ConnectionFactory().getConnection();
		IPedidoDao dao = new PedidoDao(conn);
		list = dao.listAll();
		
		} catch (Exception e) {						
			System.out.println("Problemas para Listar todos " + e.getMessage());
		}
		return list;
	}
	
}
