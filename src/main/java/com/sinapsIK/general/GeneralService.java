/*
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.general;

import com.sinapsIK.iSuper.ISuperEntity;
import com.sinapsIK.iSuper.ISuperService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
@Service
public class GeneralService extends ISuperService<ISuperEntity> {

    List<GeneralEntity> entities = new ArrayList<>();

    @Override
    public int updateEntity(int id, ISuperEntity newEntity) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(GeneralEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            GeneralEntity newGeneral = (GeneralEntity) newEntity;

            //CRUD 
            GeneralEntity oldGeneral = session.get(GeneralEntity.class, id);
            oldGeneral.setId(newGeneral.getId());
            oldGeneral.setAddress(newGeneral.getAddress());
            oldGeneral.setAnySalary(newGeneral.getAnySalary());
            oldGeneral.setAsap(newGeneral.getAsap());
            oldGeneral.setCourses(newGeneral.getCourses());
            oldGeneral.setCredentials(newGeneral.getCredentials());
            oldGeneral.setDateOfBirth(newGeneral.getDateOfBirth());
            oldGeneral.setDriverLicences(newGeneral.getDriverLicences());            
            oldGeneral.setEducationLevel(newGeneral.getEducationLevel());
            oldGeneral.setEmail(newGeneral.getEmail());
            oldGeneral.setFatherJob(newGeneral.getFatherJob());
            oldGeneral.setFatherName(newGeneral.getFatherName());
            oldGeneral.setForeignLanguages(newGeneral.getForeignLanguages());
            oldGeneral.setGender(newGeneral.getGender());
            oldGeneral.setGsm(newGeneral.getGsm());
            oldGeneral.setHomeOwnership(newGeneral.getHomeOwnership());
            oldGeneral.setIdentity(newGeneral.getIdentity());
            oldGeneral.setIllnesses(newGeneral.getIllnesses());
            oldGeneral.setIsActive(newGeneral.getIsActive());
            oldGeneral.setJobs(newGeneral.getJobs());
            oldGeneral.setLastName(newGeneral.getLastName());
            oldGeneral.setLastStatement(newGeneral.getLastStatement());
            oldGeneral.setLawConformation(newGeneral.getLawConformation());
            oldGeneral.setLivesWith(newGeneral.getLivesWith());            
            oldGeneral.setMarital(newGeneral.getMarital());
            oldGeneral.setMilitary(newGeneral.getMilitary());
            oldGeneral.setMotherJob(newGeneral.getMotherJob());
            oldGeneral.setMotherName(newGeneral.getMotherName());
            oldGeneral.setName(newGeneral.getName());
            oldGeneral.setNation(newGeneral.getNation());
            oldGeneral.setOfficeEquipments(newGeneral.getOfficeEquipments());
            oldGeneral.setPhone(newGeneral.getPhone());
            oldGeneral.setPrograms(newGeneral.getPrograms());
            oldGeneral.setRequestDate(new Date());
            oldGeneral.setSalary(newGeneral.getSalary());
            oldGeneral.setSchools(newGeneral.getSchools());
            oldGeneral.setSiblingsCount(newGeneral.getSiblingsCount());
            oldGeneral.setStartDate(newGeneral.getStartDate());            
            oldGeneral.setExperiences(newGeneral.getExperiences());            
            oldGeneral.setIsSeen(newGeneral.getIsSeen());


            session.save(oldGeneral);
            session.getTransaction().commit();

        } catch (Exception e) {
            return 0;
        } finally {
            factory.close();
        }
        return 1;
    }
    
    public int updateSeen(int id, ISuperEntity newEntity) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(GeneralEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            GeneralEntity newGeneral = (GeneralEntity) newEntity;
//GeneralEntity oldGeneral = session.get(GeneralEntity.class, id);
            //CRUD 
            GeneralEntity oldGeneral = session.get(GeneralEntity.class, id);
            oldGeneral.setIsSeen(newGeneral.getIsSeen());          

            session.save(oldGeneral);
            session.getTransaction().commit();

        } catch (Exception e) {
            return 0;
        } finally {
            factory.close();
        }
        return 1;
    }
       
    public List<GeneralEntity> getAllEntitiesByArrayParam(String sutun,String deger) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(GeneralEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            //entities = session.createQuery("from GeneralEntity WHERE JSON_CONTAINS(sablonAdi,'{\"sablonlar\":[\""+sablonAdi+"\"]}')").getResultList();
            //JSON_CONTAINS için SQL kullanmamız gerekti. Eğer class adı yazılmazsa mapping yapmıyor //{\""+icSutun+"\":\"" + deger + "\"}
            entities = session.createNativeQuery("SELECT * FROM general WHERE JSON_CONTAINS("+sutun+",'[\""+deger+"\"]')", GeneralEntity.class).getResultList();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return entities;
    }
    
    public List<GeneralEntity> getAllEntitiesByParam(String sutun,String icSutun,String deger) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(GeneralEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            //entities = session.createQuery("from GeneralEntity WHERE JSON_CONTAINS(sablonAdi,'{\"sablonlar\":[\""+sablonAdi+"\"]}')").getResultList();
            //JSON_CONTAINS için SQL kullanmamız gerekti. Eğer class adı yazılmazsa mapping yapmıyor //{\""+icSutun+"\":\"" + deger + "\"}
            entities = session.createNativeQuery("SELECT * FROM general WHERE JSON_CONTAINS("+sutun+",'{\""+icSutun+"\":\"" + deger + "\"}')", GeneralEntity.class).getResultList();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return entities;
    }
    
    public List<GeneralEntity> getAllEntitiesByIcParam(String sutun,String icSutun,String deger,String icDeger) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(GeneralEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //CRUD 
            //entities = session.createQuery("from GeneralEntity WHERE JSON_CONTAINS(sablonAdi,'{\"sablonlar\":[\""+sablonAdi+"\"]}')").getResultList();
            //JSON_CONTAINS için SQL kullanmamız gerekti. Eğer class adı yazılmazsa mapping yapmıyor //{\""+icSutun+"\":\"" + deger + "\"}
            entities = session.createNativeQuery("SELECT * FROM general WHERE JSON_CONTAINS("+sutun+",'{\""+icSutun+"\": {\""+deger+"\": \""+icDeger+"\"}}')", GeneralEntity.class).getResultList();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return entities;
    }
    
    
}
