package com.alura.test;

import com.alura.model.Conta;
import com.alura.model.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class Jpql {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);

        List<Movimentacao> resultList = query.getResultList();

        resultList.forEach(
                movimentacao -> {
                    System.out.println(movimentacao.getDescricao());
                    System.out.println(movimentacao.getTipoMovimentacao());
                    System.out.println(movimentacao.getValor());
                }
        );
    }
}
