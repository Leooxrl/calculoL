package br.com.calculo.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Caixa {

    public Caixa() {}

    public Caixa(Folha folha) {
        this.folha = folha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "folha")
    private Folha folha;

    private BigDecimal altura;

    public BigDecimal getVolume() {
        return this.folha.getComprimento().multiply(this.folha.getLargura()).multiply(this.altura);
    }

    public BigDecimal getLargura() {
        return this.folha.getLargura().subtract((new BigDecimal("2").multiply(this.altura)));
    }

    public BigDecimal getComprimento() {
        return this.folha.getComprimento().subtract((new BigDecimal("2").multiply(this.altura)));
    }

    public BigDecimal getAreaBase() {
        return getLargura().multiply(getComprimento());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Folha getFolha() {
        return folha;
    }

    public void setFolha(Folha folha) {
        this.folha = folha;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

}
