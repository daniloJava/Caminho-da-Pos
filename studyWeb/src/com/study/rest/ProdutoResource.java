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

import com.study.dao.IProdutoDao;
import com.study.dao.jdbc.ConnectionFactory;
import com.study.dao.jdbc.ProdutoDao;
import com.study.model.Produto;


@Path("/produto")
public class ProdutoResource {

	/**Requisição via GEt somente
	 * 
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Produto get(@PathParam("id") int id){
		Produto produto = new Produto();
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IProdutoDao dao = new ProdutoDao(conn);
			produto = dao.get(id);
			System.out.println(produto.getNomeProduto() + "Recuperado");
		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		
		return produto;
	}
	
	/**Requisição do Post 
	 * para fazer um insart 
	 * 
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String POST(Produto produto){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IProdutoDao dao = new ProdutoDao(conn);
			dao.insert(produto);
			System.out.println(produto.getNomeProduto() + "Inserido");

		} catch (Exception e) {
			System.out.println("Problemas para Inserir " + e.getMessage());
		}
		System.out.println(produto.getNomeProduto());
		return "1";
	}
	
	/**Put para somente colocar um Update
	 * 
	 * @param produto
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//texto plano, nenhuma aplicação será executada.
	public Produto PUT(Produto produto){
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IProdutoDao dao = new ProdutoDao(conn);
			dao.update(produto);
			System.out.println(produto.getNomeProduto() + "Atualizado");

		} catch (Exception e) {
			System.out.println("Problemas para update " + e.getMessage());
		}
		return produto;
	}
	
	/**Delete Usando um Objeto
	 * 
	 * @param produto
	 * @return
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)//texto plano, nenhuma aplicação será executada.
	public String DELETE(Produto produto) {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			IProdutoDao dao = new ProdutoDao(conn);
			dao.delete(produto);
			System.out.println(produto.getNomeProduto() + "DELETADO");

		} catch (Exception e) {
			System.out.println("Problemas para deletar " + e.getMessage());

		}

		return "{\"msg\" : \" CLiente exlcuido com sucesso.\"}";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> list(){
		List<Produto> list = new ArrayList<Produto>();
		try{ 
		Connection conn = new ConnectionFactory().getConnection();
		IProdutoDao dao = new ProdutoDao(conn);
		list = dao.listAll();
		
		} catch (Exception e) {						
			System.out.println("Problemas para Listar todos " + e.getMessage());
		}
		return list;
	}
	
}
