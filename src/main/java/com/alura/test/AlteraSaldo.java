package com.alura.test;

import com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta contaLeandro = em.find(Conta.class, 1L);

        em.getTransaction().begin();

        contaLeandro.setSaldo(440.02);

        em.getTransaction().commit();
    }
}
