/*
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.languages;

import com.sinapsIK.iSuper.ISuperEntity;
import com.sinapsIK.iSuper.ISuperService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
@Service
public class LanguagesService extends ISuperService<ISuperEntity> {

    @Override
    public int updateEntity(int id, ISuperEntity newEntity) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(LanguagesEntity.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            LanguagesEntity newLanguages = (LanguagesEntity) newEntity;

            //CRUD 
            LanguagesEntity oldLanguages = session.get(LanguagesEntity.class, id);
            oldLanguages.setId(newLanguages.getId());
            oldLanguages.setName(newLanguages.getName());
            oldLanguages.setCode(newLanguages.getCode());
            
            session.save(oldLanguages);
            session.getTransaction().commit();

        } catch (Exception e) {
            return 0;
        } finally {
            factory.close();
        }
        return 1;
    }
}
