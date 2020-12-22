/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinapsIK.iSuper;

import com.sinapsIK.iSuper.ISuperEntity;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author dijital
 * @param <T>
 */
// ISuperEntity interface de olsa generic constraint kavramı için extends ile kullanılır!!!
public interface ISuperApi<T extends ISuperEntity> {
    public List<T> getAll();

    /**
     *
     * @param newEntity implements ISuperEntity
     * @return 
     */
    public ResponseEntity<List<T>> setNew(T newEntity);
    public ResponseEntity delete(int id);
    public ResponseEntity update(int id, T newEntity);
}
