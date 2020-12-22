/*
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.languages;

import com.sinapsIK.iSuper.ISuperApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sinapsIK.util.ResponseEntityUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = "*")
@RequestMapping("/languages")
public class LanguagesApi implements ISuperApi<LanguagesEntity> {

    @Autowired
    LanguagesService LanguagesService;

    @Autowired
    ResponseEntityUtil responseEntityUtil;

    @GetMapping(
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    @Override
    public List<LanguagesEntity> getAll() {
        return (List<LanguagesEntity>) (List<?>) LanguagesService
                .getAllEntities(new LanguagesEntity());
    }

    @Override
    public ResponseEntity<List<LanguagesEntity>> setNew(LanguagesEntity newEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity update(int id, LanguagesEntity newEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
