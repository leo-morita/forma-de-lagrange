package br.com.unifil.lagrange.view;

import br.com.unifil.lagrange.controller.FormaDeNewton;

public class Main2 {
    public static void main(String[] args) {
        FormaDeNewton formaDeNewton = new FormaDeNewton();


        double x = 1.5;
        Double[] numeros = {-2.0, -1.0, 0.0, 1.0, 2.0}; // 3.5 5
        Double[] numerosDaFuncao = {-2.0, 29.0, 30.0, 31.0, 62.0};
        formaDeNewton.interpolar(x, numeros, numerosDaFuncao);

//        Double[] b = formaDeNewton.retornarResultadoD(x, numeros);
    }
}
