package com.xqd.sils.api.controller;

import com.xqd.sils.api.component.AutoComponent;
import com.xqd.sils.api.model.Autos;
import com.xqd.sils.api.value.AutoValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel F.
 */
@RestController
@RequestMapping(path = "/auto")
public class AutoController {

    private final AutoComponent autoComponent;

    @Autowired
    public AutoController(AutoComponent autoComponent) {
        this.autoComponent = autoComponent;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(AutoValue auto) {
        autoComponent.save(auto);
        return ResponseEntity.ok().build();
    }
}
