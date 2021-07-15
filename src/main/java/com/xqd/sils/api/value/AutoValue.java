package com.xqd.sils.api.value;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Miguel F.
 */
public class AutoValue {
    @Setter @Getter
    private String marca;
    @Setter @Getter
    private String modelo;
    @Getter @Setter
    private String placa;
    @Setter @Getter
    private String value;//precio
    @Setter @Getter
    private int idTipo;

}
