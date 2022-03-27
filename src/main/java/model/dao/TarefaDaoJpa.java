/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Tarefa;

/**
 *
 * @author frizz
 */
public class TarefaDaoJpa implements InterfaceDao<Tarefa> {

    @Override
    public void incluir(Tarefa entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Tarefa entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Tarefa entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Tarefa t = em.find(Tarefa.class, entidade.getId());
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Tarefa pesquisarPorId(int id) throws Exception {
        Tarefa t = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            t = em.find(Tarefa.class, id);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return t;
    }

    @Override
    public List<Tarefa> listar() throws Exception {
        List<Tarefa> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Tarefa t").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

}
