package com.xqd.sils.api.componentImpl;

import com.xqd.sils.api.component.TipoComponent;
import com.xqd.sils.api.model.Tipo;
import com.xqd.sils.api.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Miguel F.
 */
@Component
public class TipoComponentImpl implements TipoComponent {

    private final TipoRepository tipoRepository;

    @Autowired
    public TipoComponentImpl(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }
}
