package br.com.calculo.main;

import java.math.BigDecimal;

import br.com.calculo.bean.Monomio;
import br.com.calculo.bean.Polinomio;
import br.com.calculo.bean.Variavel;
import br.com.calculo.regraNegocio.BhaskaraRN;
import br.com.calculo.regraNegocio.CalculoException;
import br.com.calculo.regraNegocio.DerivadaRN;
import br.com.calculo.regraNegocio.OperacaoRN;
import br.com.calculo.regraNegocio.PolinomioRN;



public class Principal {

    public static void main(String[] args) throws CalculoException {

        BigDecimal dimLarguraFolha = BigDecimal.TEN;
        BigDecimal dimComprimentoFolha = new BigDecimal("20");

        // equação do volume da caixa V(x) = 4x³ - 60x² + 200x
        Polinomio funcaoVolume = montarEquacaoVolume(dimLarguraFolha, dimComprimentoFolha);

        // é necessário derivar a função de volume para encontrar os máximos e mínimos
        Polinomio derivadaVolume = DerivadaRN.derivar(funcaoVolume);

        BigDecimal[] solucoes = BhaskaraRN.resolver(derivadaVolume);

        // calcular o volume com as soluções dadas.



    }

    /**
     * Monta a equação de volume da caixa.
     * 
     * @param dimensaoLarguraFolha
     * @param dimensaoComprimentoFolha
     * @return
     */
    private static Polinomio montarEquacaoVolume(BigDecimal dimensaoLarguraFolha,
                    BigDecimal dimensaoComprimentoFolha) {
        Variavel x = new Variavel();
        Monomio altura = new Monomio(x);

        Monomio larguraFolha = new Monomio(dimensaoLarguraFolha);
        Monomio corte = new Monomio(new BigDecimal("2").negate(), x);
        Monomio comprimentoFolha = new Monomio(dimensaoComprimentoFolha);

        // 20 -2X
        Polinomio comprimentoCaixa = new Polinomio(comprimentoFolha, corte);
        // 10 -2X
        Polinomio larguraCaixa = new Polinomio(larguraFolha, corte);
        Polinomio alturaCaixa = new Polinomio(altura);


        // (10 -2X) * (20 -2X)
        Polinomio produtoLarguraComprimento =
                        OperacaoRN.multiplicarPolinomios(larguraCaixa, comprimentoCaixa);

        // 200 -20X -40X + 4X²
        // 4X² -60X + 200
        System.out.println(produtoLarguraComprimento);

        // x(4x² -60x +200)
        // 4x³ - 60x² + 200x
        Polinomio produtoLarguraComprimentoAltura =
                        OperacaoRN.multiplicarPolinomios(alturaCaixa, produtoLarguraComprimento);
        System.out.println(produtoLarguraComprimentoAltura);

        PolinomioRN.ordenarTermos(produtoLarguraComprimentoAltura);

        return produtoLarguraComprimentoAltura;
    }
}
