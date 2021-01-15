//classe que vai receber as requisiçoes http
package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;	
	
	@GetMapping("/produtos")//listando todos os produtos
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")//listando apenas um produto pelo id
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping("/produto")//salvar produto
	public Produto salvaProduto(@RequestBody Produto produto){//requestbody pq vai vim no corpo da requisiçao
		return produtoRepository.save(produto);
	}


	@DeleteMapping("/produto")
	public void deletarProduto(@RequestBody Produto produto) { //deletando produto
		produtoRepository.delete(produto);
		
	}

	@PutMapping("/produto") //rota para atualizar produto
	public Produto atualizaProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	
	
	
	
	
	
}



