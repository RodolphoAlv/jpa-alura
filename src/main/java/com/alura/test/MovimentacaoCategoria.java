package com.alura.test;

import com.alura.model.Categoria;
import com.alura.model.Conta;
import com.alura.model.Movimentacao;
import com.alura.model.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class MovimentacaoCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        Categoria categoria1 = new Categoria("Viagens");
        Categoria categoria2 = new Categoria("Negocios");

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setDescricao("Viagem a SP");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setData(LocalDateTime.now());
        movimentacao1.setValor(new BigDecimal("330.00"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setDescricao("Viagem a RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setValor(new BigDecimal("400.00"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao2.setConta(conta);

        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();
        em.close();
    }
}
