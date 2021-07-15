package com.xqd.sils.api.componentImpl;

import com.xqd.sils.api.component.AutoComponent;
import com.xqd.sils.api.exceptions.AutoException;
import com.xqd.sils.api.model.Autos;
import com.xqd.sils.api.model.Tipo;
import com.xqd.sils.api.repository.AutoRepository;
import com.xqd.sils.api.repository.TipoRepository;
import com.xqd.sils.api.util.Messages;
import com.xqd.sils.api.value.AutoValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Miguel F.
 */
@Component
public class AutoComponentImpl implements AutoComponent {
    private final AutoRepository autoRepository;
    private final TipoRepository tipoRepository;

    @Autowired
    public AutoComponentImpl(AutoRepository autoRepository, TipoRepository tipoRepository) {
        this.autoRepository = autoRepository;
        this.tipoRepository = tipoRepository;
    }


    @Override
    public void save(AutoValue auto) {
        Autos byPlaca = autoRepository.findByPlaca(auto.getPlaca());
        if (byPlaca != null) throw AutoException.of(Messages.RESPONSE_AUTO_EXISTE.getCause());
        else {
            Optional<Tipo> byId = tipoRepository.findById(auto.getIdTipo());
            byId.ifPresentOrElse(x -> {
                Autos build = Autos.Builder.anAutos().marca(auto.getMarca()).modelo(auto.getModelo()).placa(auto.getPlaca()).fkIdTipo(x).build();
                autoRepository.save(build);
            }, AutoComponentImpl::exception);
        }
    }

    private static void exception() {
        throw AutoException.of(Messages.RESPONSE_TIPO_NO_EXISTE.getCause());
    }

}
