package com.study.rest;

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
		cliente.setCodigo(id);
		cliente.setNome("Juquinha Show");
		
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

		System.out.println(cliente.getNome() + "aPLICADO");
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
	public String DELETE(Cliente cliente){

		System.out.println(cliente.getNome() + "DELETADO");
		return "{\"msg\" : \" CLiente exlcuido com sucesso.\"}";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> list(){
		List<Cliente> list = new ArrayList<Cliente>();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setNome("DANILO");
		cliente.setInscricaoFederal("1232434");
		list.add(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setCodigo(2);
		cliente2.setNome("JOAOZINHO");
		cliente2.setInscricaoFederal("1232434");
		list.add(cliente2);
		
		return list;
	}
	
}
