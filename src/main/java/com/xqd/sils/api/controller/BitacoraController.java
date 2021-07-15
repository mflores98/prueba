package com.xqd.sils.api.controller;

import com.xqd.sils.api.component.BitacoraComponent;
import com.xqd.sils.api.model.Bitacora;
import com.xqd.sils.api.value.BitacoraValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel F.
 */
@RestController
@RequestMapping(path = "/bitacora")
public class BitacoraController {
    private final BitacoraComponent bitacoraComponent;

    @Autowired
    public BitacoraController(BitacoraComponent bitacoraComponent) {
        this.bitacoraComponent = bitacoraComponent;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(BitacoraValue bitacora) {
        bitacoraComponent.save(bitacora);
        return ResponseEntity.ok(bitacora);
    }


}
