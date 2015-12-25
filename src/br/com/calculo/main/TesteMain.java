package br.com.calculo.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.calculo.bean.Monomio;
import br.com.calculo.bean.Polinomio;
import br.com.calculo.bean.Variavel;
import br.com.calculo.regraNegocio.MonomioRN;

public class TesteMain {


    public static void main(String[] args) {

        Variavel x = new Variavel();
        Monomio corte = new Monomio(new BigDecimal("2").negate(), x);
        Monomio comprimentoFolha = new Monomio(new BigDecimal("20"));

        // 20 - 2X
        Polinomio comprimentoCaixa = new Polinomio(comprimentoFolha, corte);



        Set<Monomio> meuSet = new LinkedHashSet<>();

        meuSet.add(new Monomio(new BigDecimal("2")));
        meuSet.add(new Monomio(new Variavel()));
        meuSet.add(new Monomio(new BigDecimal("3"), new Variavel("y")));

        Iterator<Monomio> iterator = meuSet.iterator();
        while (iterator.hasNext()) {
            Monomio i = iterator.next();

            if (MonomioRN.ehSemelhante(i, new Monomio(new Variavel()))) {

                System.out.println("funfa");

                i = new Monomio(new BigDecimal("2"), new Variavel("z"));
            }
        }

        iterator = meuSet.iterator();
        while (iterator.hasNext()) {

            Monomio i = iterator.next();
            System.out.println(i.toString());
        }


    }
}
