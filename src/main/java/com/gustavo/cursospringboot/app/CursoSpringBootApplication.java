package com.gustavo.cursospringboot.app;

import com.gustavo.cursospringboot.app.domain.*;
import com.gustavo.cursospringboot.app.domain.enums.EstadoPagamento;
import com.gustavo.cursospringboot.app.domain.enums.TipoCliente;
import com.gustavo.cursospringboot.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A implementação da interface CommandLineRunner serve para instanciar
 * os objetos de dominio e salva-los no banco de dados
 * */
@SpringBootApplication
public class CursoSpringBootApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        //Instanciando categorias
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(null,"Informática"));
        categorias.add(new Categoria(null,"Escritório"));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(null,"Computador",2000.00));
        produtos.add(new Produto(null,"Impressora",800.00));
        produtos.add(new Produto(null,"Mouse",80.00));

        //Associações
        categorias.get(0).getProdutos().addAll(produtos);
        categorias.get(1).getProdutos().add(produtos.get(1));

        produtos.get(0).getCategorias().add(categorias.get(0));
        produtos.get(1).getCategorias().addAll(Arrays.asList(categorias.get(1),categorias.get(0)));
        produtos.get(2).getCategorias().add(categorias.get(0));

        categoriaRepository.saveAll(categorias);
        produtoRepository.saveAll(produtos);

        //Estados e Cidades

        Estado est1 = new Estado(null,"Minas Gerais");
        Estado est2 = new Estado(null,"Sao Paulo");

        Cidade cid1 = new Cidade(null,"uberlandia",est1);
        Cidade cid2 = new Cidade(null,"Sao paulo",est2);
        Cidade cid3 = new Cidade(null,"Campinas",est2);

        est1.getCidades().add(cid1);
        est2.getCidades().addAll(Arrays.asList(cid2,cid3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

        //Endereço e cliente

        Cliente cli1 = new Cliente("Maria Silva","maria@gmail.com","12345678912",TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("12345678","87654321"));

        Endereco e1 = new Endereco("Rua Flores","300","ap 303 ", "Jardim", "12345678",cid2,cli1);
        Endereco e2 = new Endereco("Avenida Matos","108", "Sala 800", "Centro","12345678",cid2,cli1);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

        // Pedidos

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
        Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,e2);

        Pagamento pgt1 = new PagamentoComCartão(null,EstadoPagamento.QUITADO,ped1,6);
        ped1.setPagamento(pgt1);

        Pagamento pgt2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
        ped2.setPagamento(pgt2);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
        pagamentoRepository.saveAll(Arrays.asList(pgt1,pgt2));

        //itens e pedidos

        ItemPedido ip1 = new ItemPedido(ped1,produtos.get(0),0.00,1,2000.00);
        ItemPedido ip2 =  new ItemPedido(ped1,produtos.get(1),0.0,2,80.00);
        ItemPedido ip3 = new ItemPedido(ped2,produtos.get(2),0.00,2,800.00);

        ped1.getItens().addAll(Arrays.asList(ip1,ip2));
        ped2.getItens().add(ip3);

        produtos.get(0).getItens().add(ip1);
        produtos.get(1).getItens().add(ip3);
        produtos.get(2).getItens().add(ip2);

        itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
    }
}
