package com.xqd.sils.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Miguel F.
 */
@Entity
@Table(name = "estado")

public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    @Column(name = "estado", nullable = false)
    private String estado;
}
