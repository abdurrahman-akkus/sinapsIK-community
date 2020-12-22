/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinapsIK.iSuper;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sinapsIK.iSuper.ISuperEntity;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author dijital
 * @param <T> extends ISuperEntity
 */
public abstract class ISuperService<T extends ISuperEntity> {
    
    //TODO queryBuilder oluşturulacak. query string başlatılacak ve builder pattern ile bir sonraki aşamaya aktarılacak
    // ÖRN: start().where("x="+x).order("a ASC") => "FROM " + superEntity.getClass().getSimpleName()).getResultList()+"x="+x+"a ASC";

    List<ISuperEntity> superEntities = new ArrayList();
    ISuperEntity superEntity;

    public List<ISuperEntity> getAllEntities(ISuperEntity superEntity) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            superEntities = session
                    .createQuery("FROM " + superEntity.getClass().getSimpleName()).getResultList();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return superEntities;
    }

    public ISuperEntity getSingleEntity(ISuperEntity superEntity, String kosullar, String siralama) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            siralama = siralama.equals("") ? "" : " ORDER BY " + siralama;
            //CRUD 
            superEntity = (ISuperEntity) session
                    .createQuery("FROM " + superEntity.getClass().getSimpleName()
                            + " WHERE " + kosullar + siralama).getSingleResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            // Hiç bir sonuç dönmemesi durumunda yapılan exception handling
            System.out.println(new Date() + "  INFO: Hiç bir sonuç dönmedi: "
                    + superEntity.getClass().getSimpleName());
            return null;
        } finally {
            factory.close();
        }
        return superEntity;
    }

    public List<ISuperEntity> getAllEntitiesBy(ISuperEntity superEntity, String kosullar) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            superEntities = session
                    .createQuery("FROM " + superEntity.getClass().getSimpleName()
                            + " WHERE " + kosullar).getResultList();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return superEntities;
    }
    
    public List<ISuperEntity> getAllEntitiesWithTableBy(ISuperEntity superEntity, String table, String kosullar) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass().getDeclaredClasses().getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        
        String className=superEntity.getClass().getName();
        String classNameSplit=className.split("\\.")[3];
        System.out.println("cN:"+classNameSplit);
        try {
                    System.out.println("cN2:"+className);

            session.beginTransaction();

            //CRUD 
            superEntities = session
                    .createQuery("FROM " + className
                            + " WHERE " + kosullar).getResultList();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return superEntities;
    }

    public List<ISuperEntity> getAllEntitiesOrder(ISuperEntity superEntity, String siralama) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            superEntities = session
                    .createQuery("FROM " + superEntity.getClass().getSimpleName()
                            + " ORDER BY " + siralama).getResultList();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return superEntities;
    }

    public List<ISuperEntity> getAllEntitiesByOrder(ISuperEntity superEntity, String kosullar, String siralama) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(superEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            superEntities = session
                    .createQuery("FROM " + superEntity.getClass().getSimpleName()
                            + " WHERE " + kosullar
                            + " ORDER BY " + siralama).getResultList();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return superEntities;
    }

    public int newEntity(ISuperEntity newEntity) {
        int yeniId = 0;
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(newEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.save(newEntity);

            yeniId = newEntity.getId();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return yeniId;
    }

    public int deleteEntity(int id, ISuperEntity newEntity) {
        int basarim = 0;
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(newEntity.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            ISuperEntity superEntity = session.get(newEntity.getClass(), id);
            session.delete(superEntity);

            session.getTransaction().commit();
            basarim = 1;
        } finally {
            factory.close();
        }
        return basarim;
    }

    public abstract int updateEntity(int id, ISuperEntity newEntity);
}
