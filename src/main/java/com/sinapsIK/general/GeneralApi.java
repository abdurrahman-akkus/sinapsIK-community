/*
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.general;

import com.sinapsIK.iSuper.ISuperApi;
import com.sinapsIK.iSuper.ISuperEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sinapsIK.util.ResponseEntityUtil;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = "*")
@RequestMapping("/general")
public class GeneralApi implements ISuperApi<GeneralEntity> {

    @Autowired
    GeneralService GeneralService;

    @Autowired
    ResponseEntityUtil responseEntityUtil;

    @GetMapping(
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    @Override
    public List<GeneralEntity> getAll() {
        return (List<GeneralEntity>) (List<?>) GeneralService
                .getAllEntities(new GeneralEntity());
    }
    
    @PutMapping(path = "/seen/{id}")
    public ResponseEntity updateSeen(
            @PathVariable int id,
            @Valid @RequestBody GeneralEntity newEntity) {
        int basarim = GeneralService.updateSeen(id, newEntity);
        return responseEntityUtil.getResponse(id, basarim);
    }

    @GetMapping(path = "/{sutun}/{deger}",
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<GeneralEntity> getAllByParam(@PathVariable String sutun, @PathVariable String deger) {
        return (List<GeneralEntity>) (List<?>) GeneralService
                .getAllEntitiesBy(new GeneralEntity(), sutun+"='" + deger + "'");
    }
    
    @GetMapping(path = "/json/{sutun}/{deger}",
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<GeneralEntity> getAllJsonArrayByParam(@PathVariable String sutun, @PathVariable String deger) {
        return (List<GeneralEntity>) (List<?>) GeneralService
                .getAllEntitiesByArrayParam(sutun,deger);
    }
    
    @GetMapping(path = "/json/{sutun}/{icSutun}/{deger}",
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<GeneralEntity> getAllJsonByParam(@PathVariable String sutun,@PathVariable String icSutun, @PathVariable String deger) {
        return (List<GeneralEntity>) (List<?>) GeneralService
                .getAllEntitiesByParam(sutun,icSutun,deger);
    }
    
    @GetMapping(path = "/json/{sutun}/{icSutun}/{deger}/{icDeger}",
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<GeneralEntity> getAllJsonByParam(@PathVariable String sutun,@PathVariable String icSutun, @PathVariable String deger, @PathVariable String icDeger) {
        return (List<GeneralEntity>) (List<?>) GeneralService
                .getAllEntitiesByIcParam(sutun,icSutun,deger,icDeger);
    }

    

    @PostMapping(
            consumes = {
                MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE})
    @Override
    public ResponseEntity setNew(@Valid @RequestBody GeneralEntity newEntity) {
        int basarim = GeneralService.newEntity(newEntity);
        return responseEntityUtil.getResponse(basarim);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity delete(@PathVariable int id) {
        int basarim = GeneralService.deleteEntity(id, new GeneralEntity());
        return responseEntityUtil.getResponse(basarim);
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity update(
            @PathVariable int id,
            @Valid @RequestBody GeneralEntity newEntity) {
        int basarim = GeneralService.updateEntity(id, newEntity);
        return responseEntityUtil.getResponse(id, basarim);
    }
}
