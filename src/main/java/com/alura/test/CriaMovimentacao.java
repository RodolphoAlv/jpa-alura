package com.alura.test;

import com.alura.model.Conta;
import com.alura.model.Movimentacao;
import com.alura.model.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CriaMovimentacao {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia(12341);
        conta.setNumero(67896);
        conta.setSaldo(300.0);
        conta.setTitular("Fernando");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setValor(new BigDecimal("200.00"));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();
    }
}
