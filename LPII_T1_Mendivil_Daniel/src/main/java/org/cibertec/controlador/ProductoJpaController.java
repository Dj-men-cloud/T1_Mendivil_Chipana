package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import org.cibertec.model.Categoria;
import org.cibertec.model.Producto;
import org.cibertec.util.JPAUtil;

public class ProductoJpaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	
	public ProductoJpaController() {
		this.emf = JPAUtil.getEntityManagerFactory();
	}
	
	public ProductoJpaController (EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public  List<Producto> findAllProducto(){
		EntityManager em = getEntityManager();
		try {
			TypedQuery<Producto> q = em.createQuery("SELECT e FROM Producto e", Producto.class);
			return q.getResultList();
		}finally {
			em.close();
		}
	}
	public Categoria buscarById(int codigo) {
		EntityManager em= getEntityManager();
		try {
			return em.find(Categoria.class, codigo);			
		}finally {
			em.close();
		}
	}

}
