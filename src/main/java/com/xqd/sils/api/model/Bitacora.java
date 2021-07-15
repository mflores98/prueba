package com.xqd.sils.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Miguel F.
 */
@Entity
@Table(name = "bitacora")
@NamedQueries({
        @NamedQuery(name = "Bitacora.findByPlaca",//buscar el auto que no ha salido
                query = " select b from Bitacora b inner join Autos a on a.id = b.fkIdAuto.id " +
                        " and b.fkIdEstatus.id <> 2 " +
                        " where a.placa=:placa")})
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;

    @Getter
    @Setter
    @Column(name = "salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salida;

    @Getter
    @Setter
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado fkIdEstatus;

    @Getter
    @Setter
    @JoinColumn(name = "fk_id_auto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Autos fkIdAuto;

    public Bitacora() {
    }

    public Bitacora(Integer id, Date entrada, Date salida, Estado fkIdEstatus, Autos fkIdAuto) {
        this.id = id;
        this.entrada = entrada;
        this.salida = salida;
        this.fkIdEstatus = fkIdEstatus;
        this.fkIdAuto = fkIdAuto;
    }


    public static final class Builder {
        private Integer id;
        private Date entrada;
        private Date salida;
        private Estado fkIdEstatus;
        private Autos fkIdAuto;

        private Builder() {
        }

        public static Builder aBitacora() {
            return new Builder();
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder entrada(Date entrada) {
            this.entrada = entrada;
            return this;
        }

        public Builder salida(Date salida) {
            this.salida = salida;
            return this;
        }

        public Builder fkIdEstatus(Estado fkIdEstatus) {
            this.fkIdEstatus = fkIdEstatus;
            return this;
        }

        public Builder fkIdAuto(Autos fkIdAuto) {
            this.fkIdAuto = fkIdAuto;
            return this;
        }

        public Bitacora build() {
            Bitacora bitacora = new Bitacora();
            bitacora.setId(id);
            bitacora.setEntrada(entrada);
            bitacora.setSalida(salida);
            bitacora.setFkIdEstatus(fkIdEstatus);
            bitacora.setFkIdAuto(fkIdAuto);
            return bitacora;
        }
    }

    @Override
    public String toString() {
        return "Bitacora{" +
                "id=" + id +
                ", entrada=" + entrada +
                ", salida=" + salida +
                ", fkIdEstatus=" + fkIdEstatus +
                ", fkIdAuto=" + fkIdAuto +
                '}';
    }
}
