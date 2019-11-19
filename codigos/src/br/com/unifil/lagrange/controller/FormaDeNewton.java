package br.com.unifil.lagrange.controller;

public class FormaDeNewton {
    public void interpolar(double valorDeX, Double[] numeros, Double[] numerosDaFuncao) {
        Double resultado;
        Double[] resultadosOrdem = new Double[numerosDaFuncao.length-1];
        Double[] resutadosDeD = retornarResultadoD(valorDeX, numeros);



        for (int i = 0; i < numerosDaFuncao.length-1; i++) {
            resultado = (numerosDaFuncao[i+1] - numerosDaFuncao[i]) / (numeros[i+1] - numeros[i]);
            resultadosOrdem[i] = resultado;
        }



        for (int i = 0; i < resultadosOrdem.length; i++) {
            System.out.println(resultadosOrdem[i]);
        }
    }

    public Double[] retornarResultadoD(double valorDeX, Double... numeros) {
        Double[] arrayRetorno = new Double[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            Double D = 1.0;
            for (int j = 0; j < i; j++) {
                D *= (valorDeX + numeros[j]);
            }
            if (i == 0) {
                arrayRetorno[i] = numeros[i];
            } else {
                arrayRetorno[i] = D;
            }
        }

        return arrayRetorno;
    }
}
