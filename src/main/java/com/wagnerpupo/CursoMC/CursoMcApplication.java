package com.wagnerpupo.CursoMC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wagnerpupo.CursoMC.domain.Categoria;
import com.wagnerpupo.CursoMC.domain.Cidade;
import com.wagnerpupo.CursoMC.domain.Cliente;
import com.wagnerpupo.CursoMC.domain.Endereco;
import com.wagnerpupo.CursoMC.domain.Estado;
import com.wagnerpupo.CursoMC.domain.Produto;
import com.wagnerpupo.CursoMC.domain.enums.TipoCliente;
import com.wagnerpupo.CursoMC.repositories.CategoriaRepository;
import com.wagnerpupo.CursoMC.repositories.CidadeRepository;
import com.wagnerpupo.CursoMC.repositories.ClienteRepository;
import com.wagnerpupo.CursoMC.repositories.EnderecoRepository;
import com.wagnerpupo.CursoMC.repositories.EstadoRepository;
import com.wagnerpupo.CursoMC.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null,"Informatica");
		Categoria cat2 = new Categoria (null,"Escritorio");
		
		Produto p1 = new Produto (null, "Computador",2000.00);
		Produto p2 = new Produto (null, "Impressora",800.00);
		Produto p3 = new Produto (null, "Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado (null,"Minas Gerais");
		Estado est2 = new Estado (null,"Sao Paulo");
		
		Cidade c1 = new Cidade (null,"Uberlandia", est1);
		Cidade c2 = new Cidade (null,"Sao Paulo", est2);
		Cidade c3 = new Cidade (null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Valda", "MariaValda@gmail.com","3637114712541",TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("32232322","25252222"));
		
		Endereco e1= new Endereco (null,"Rua Flores","300","ap403","Jardim","382200834", cli1,c1);
		Endereco e2= new Endereco (null,"Avenida Matos","105","sala 8000","Centro","382202524", cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
