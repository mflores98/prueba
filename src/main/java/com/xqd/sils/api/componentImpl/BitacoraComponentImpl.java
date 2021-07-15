package com.xqd.sils.api.componentImpl;

import com.xqd.sils.api.component.BitacoraComponent;
import com.xqd.sils.api.model.Autos;
import com.xqd.sils.api.model.Bitacora;
import com.xqd.sils.api.model.Estado;
import com.xqd.sils.api.repository.AutoRepository;
import com.xqd.sils.api.repository.BitacoraRepository;
import com.xqd.sils.api.repository.EstadoRepository;
import com.xqd.sils.api.value.BitacoraValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @author Miguel F.
 */
@Component
public class BitacoraComponentImpl implements BitacoraComponent {

    private final BitacoraRepository bitacoraRepository;
    private final EstadoRepository estadoRepository;
    private final AutoRepository autoRepository;

    @Autowired
    public BitacoraComponentImpl(BitacoraRepository bitacoraRepository, EstadoRepository estadoRepository, AutoRepository autoRepository) {
        this.bitacoraRepository = bitacoraRepository;
        this.estadoRepository = estadoRepository;
        this.autoRepository = autoRepository;
    }

    public void save(BitacoraValue value) {
        Bitacora bitacora = bitacoraRepository.findByPlaca(value.getPlaca());//busca el que no ha salido o no exista y dar entrada

        if (bitacora != null){
            bitacora.setSalida(value.getHoraChecar());
            bitacoraRepository.save(bitacora);
        }else {
            Optional<Estado> byId = estadoRepository.findById(1);//1 es el id de entrada
            Autos byPlaca = autoRepository.findByPlaca(value.getPlaca());
            Bitacora bit = Bitacora.Builder.aBitacora().fkIdEstatus(byId.get()).entrada(value.getHoraChecar()).fkIdAuto(byPlaca).build();
            bitacoraRepository.save(bit);
        }
    }
}
