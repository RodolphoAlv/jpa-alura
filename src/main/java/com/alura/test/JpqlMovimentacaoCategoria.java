package com.alura.test;

import com.alura.model.Categoria;
import com.alura.model.Conta;
import com.alura.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpqlMovimentacaoCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        String jpql = "select m from Movimentacao m join m.categorias c" +
                "where c = :pCategoria";

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultList = query.getResultList();

        resultList.forEach(
                movimentacao -> {
                    System.out.println(movimentacao.getCategorias().size());
                    System.out.println(movimentacao.getDescricao());
                    System.out.println(movimentacao.getTipoMovimentacao());
                    System.out.println(movimentacao.getValor());
                }
        );
    }
}
