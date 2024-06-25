package org.example;

import org.example.conexiones.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSession();
        if (session != null ){
            System.out.println("Conectado");
        }
        else{
            System.out.println("No Conectado");
    }
    }
}