package br.com.calculo.main;

import java.math.BigDecimal;

import br.com.calculo.bean.Monomio;
import br.com.calculo.bean.Variavel;
import br.com.calculo.entidades.Caixa;
import br.com.calculo.entidades.Folha;

public class Calculo {

    /**
     * Uma caixa sem tampa será feita recortando-se pequenos quadrados congruentes dos cantos de uma
     * folha de tamanho 'largura' * 'comprimento' e dobrando-se os lados para cima. Que tamanho os
     * quadrados das bordas devem ter para que a caixa chegue à sua capacidade máxima?
     * 
     * @param folha
     * @return
     */
    public Caixa calcularCaixaCapacidadeMaxima(Folha folha) {
        // função volume V(x) =
        Monomio largura = new Monomio(folha.getLargura());
        Monomio comprimento = new Monomio(folha.getComprimento());

        Variavel x = new Variavel();
        Monomio _2xNegativo = new Monomio(new BigDecimal("2").negate(), x);
        Monomio mx = new Monomio(x);



        Caixa caixa = new Caixa(folha);

        /*
         * equação do volume: V = Sb * h Sb = (largura - (2 * x)) * (comprimento - (2 * x)) Sb =
         * (largura * comprimento) -(2 * largura * x) -(2 * comprimento * x) + 4x²
         * 
         * V(x) = x * ((largura - (2 * x)) * (comprimento - (2 * x))) V(x) =
         * 
         * V(x) = (largura - 2 * x) * (comprimento - 2 * x)
         */

        return caixa;

    }

}
