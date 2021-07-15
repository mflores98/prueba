package com.xqd.sils.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Miguel F.
 */
@Entity
@Table(name = "tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    @Column(name = "tipo", nullable = false)
    private String modelo;
    @Getter @Setter
    @Column(name = "value", nullable = false)
    private String value;

    public Tipo() {
    }

    public Tipo(Integer id, String modelo, String value) {
        this.id = id;
        this.modelo = modelo;
        this.value = value;
    }
}
