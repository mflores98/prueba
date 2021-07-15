package com.xqd.sils.api.repository;

import com.xqd.sils.api.model.Autos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miguel F.
 */
public interface AutoRepository extends JpaRepository<Autos, Integer> {
    Autos findByPlaca(String placa);
}
