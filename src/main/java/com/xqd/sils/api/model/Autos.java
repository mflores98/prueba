package com.xqd.sils.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Miguel F.
 */
@Entity
@Table(name = "autos")
public class Autos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    @Column(name = "marca", nullable = false)
    private String marca;
    @Getter
    @Setter
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Getter
    @Setter
    @Column(name = "placa", nullable = false)
    private String placa;

    @Getter
    @Setter
    @JoinColumn(name = "fk_id_tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tipo fkIdTipo;
    public Autos() {
    }

    public Autos(Integer id, String marca, String modelo, String placa, Tipo fkIdTipo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.fkIdTipo = fkIdTipo;
    }


    public static final class Builder {
        private Integer id;
        private String marca;
        private String modelo;
        private String placa;
        private Tipo fkIdTipo;

        private Builder() {
        }

        public static Builder anAutos() {
            return new Builder();
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder placa(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder fkIdTipo(Tipo fkIdTipo) {
            this.fkIdTipo = fkIdTipo;
            return this;
        }

        public Autos build() {
            Autos autos = new Autos();
            autos.setId(id);
            autos.setMarca(marca);
            autos.setModelo(modelo);
            autos.setPlaca(placa);
            autos.setFkIdTipo(fkIdTipo);
            return autos;
        }
    }
}


