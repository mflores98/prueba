package com.xqd.sils.api.value;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Miguel F.
 */
public class BitacoraValue {

    @Getter @Setter
    private String placa;
    //    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Getter @Setter
    private Date horaChecar;

}
