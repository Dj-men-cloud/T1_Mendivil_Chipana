package org.cibertec.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("LPII_T1_Mendivil_Daniel");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("EntityManagerFactory cerrado correctamente");
        }
    }
}