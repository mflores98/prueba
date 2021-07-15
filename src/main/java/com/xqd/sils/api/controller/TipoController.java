package com.xqd.sils.api.controller;

import com.xqd.sils.api.component.TipoComponent;
import com.xqd.sils.api.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Miguel F.
 */
@RestController
@RequestMapping(path = "/tipo")
public class TipoController {

    private final TipoComponent tipoComponent;

    @Autowired
    public TipoController(TipoComponent tipoComponent) {
        this.tipoComponent = tipoComponent;
    }

    @GetMapping("/findAll")
    public List<Tipo> findAll() {
        return tipoComponent.findAll();
    }
}
