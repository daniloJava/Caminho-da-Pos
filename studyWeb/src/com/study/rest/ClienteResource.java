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
import com.study.dao.jdbc.ClienteDao;
import com.study.dao.jdbc.ConnectionFactory;
import com.study.model.Cliente;

/**Clase para colocar os metodos de acesso 
 * a classe cliente, onde o Rest entenda ond eprecis amapear
 * 
 * @author Danilo Silva
 *
 */
@Path("/cliente")//Path de mapeamento pra que a servlet entenda.
public class ClienteResource {
	
	/**Requisição via GEt somente
	 * 
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Cliente get(@PathParam("id") int id){
		Cliente cliente = new Cliente();
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IClienteDao dao = new ClienteDao(conn);
			cliente = dao.get(id);
			System.out.println(cliente.getNome() + "Recuperado");
		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		
		return cliente;
	}
	
	/**Requisição do Post 
	 * para fazer um insart 
	 * 
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String POST(Cliente cliente){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IClienteDao dao = new ClienteDao(conn);
			dao.insert(cliente);
			System.out.println(cliente.getNome() + "Inserido");

		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		System.out.println(cliente.getNome());
		return "1";
	}
	
	/**Put para somente colocar um Update
	 * 
	 * @param cliente
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Cliente PUT(Cliente cliente){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IClienteDao dao = new ClienteDao(conn);
			dao.update(cliente);
			System.out.println(cliente.getNome() + "Atualizado");

		} catch (Exception e) {
			System.out.println("Problemas para update " + e.getMessage());
		}
		return cliente;
	}
	
	/**Delete Usando um Objeto
	 * 
	 * @param cliente
	 * @return
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String DELETE(Cliente cliente) {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IClienteDao dao = new ClienteDao(conn);
			dao.delete(cliente);
			System.out.println(cliente.getNome() + "DELETADO");

		} catch (Exception e) {
			System.out.println("Problemas para deletar " + e.getMessage());

		}

		return "{\"msg\" : \" CLiente exlcuido com sucesso.\"}";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> list(){
		List<Cliente> list = new ArrayList<Cliente>();
		try{ 
		Connection conn = new ConnectionFactory().getConnection();
		IClienteDao dao = new ClienteDao(conn);
		list = dao.listAll();
		
		} catch (Exception e) {						
			System.out.println("Problemas para Listar todos " + e.getMessage());
		}
		return list;
	}
}
