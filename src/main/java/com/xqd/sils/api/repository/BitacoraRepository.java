package com.xqd.sils.api.repository;

import com.xqd.sils.api.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQueries;
import java.util.List;

/**
 * @author Miguel F.
 */

public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {
    Bitacora findByPlaca(String placa);
}
