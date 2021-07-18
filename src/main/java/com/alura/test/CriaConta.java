package com.alura.test;

import com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Leandro");
        conta.setNumero(1234);
        conta.setAgencia(4321);
        conta.setSaldo(12.23);
        conta.setNumero(789);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();
    }
}
