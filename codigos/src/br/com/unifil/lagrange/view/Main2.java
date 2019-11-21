package br.com.unifil.lagrange.view;

import br.com.unifil.lagrange.controller.FormaDeNewton;

public class Main2 {
    public static void main(String[] args) {
        FormaDeNewton formaDeNewton = new FormaDeNewton();


        double x = 1.17;
        Double[] numeros = {1.0, 1.1, 1.3, 1.4};
        Double[] numerosDaFuncao = {-1.0, 1.51, 2.56, -3.1};
        formaDeNewton.interpolar(x, numeros, numerosDaFuncao);

//        Double[] b = formaDeNewton.retornarResultadoD(x, numeros);
    }
}
