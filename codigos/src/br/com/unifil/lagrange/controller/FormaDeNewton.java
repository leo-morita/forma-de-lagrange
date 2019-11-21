package br.com.unifil.lagrange.controller;

public class FormaDeNewton {
    public void interpolar(double valorDeX, Double[] numeros, Double[] numerosDaFuncao) {

        Double resultado;
        Double[] resultadosOrdem;
//        Double[] resutadosDeD = retornarResultadoD(valorDeX, numeros);

        int contador = numerosDaFuncao.length;
        resultadosOrdem = new Double[numerosDaFuncao.length];

        if (contador == 2) { // Se tiver 2 valores de x
            calcularOrdem1(numeros, numerosDaFuncao, resultadosOrdem, contador);
            final double P =
                    numerosDaFuncao[0] + (valorDeX - numeros[0]) * resultadosOrdem[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]);
            imprimirP(valorDeX, P);

        } else if (contador == 3) { // Se tiver 3 valores de x
            for (int i = 0; i < contador-1; i++) {
                resultado = (numerosDaFuncao[i + 1] - numerosDaFuncao[i]) / (numeros[i + 1] - numeros[i]);
                resultadosOrdem[i] = resultado;
            }

            Double[] resultadosOrdem2 = new Double[contador-2];
            calcularOrdem2(numeros, resultadosOrdem, contador, resultadosOrdem2);

            final double P =
                    numerosDaFuncao[0] + (valorDeX - numeros[0]) * resultadosOrdem[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]) * resultadosOrdem2[0];
            imprimirP(valorDeX, P);
        } else if (contador == 4) { // Se tiver 4 valores de x
            calcularOrdem1(numeros, numerosDaFuncao, resultadosOrdem, contador);

            Double[] resultadosOrdem2 = new Double[contador-2];
            calcularOrdem2(numeros, resultadosOrdem, contador, resultadosOrdem2);

            Double[] resultadosOrdem3 = new Double[contador-3];
            calcularOrdem3(numeros, contador, resultadosOrdem2, resultadosOrdem3);

            final double P =
                    numerosDaFuncao[0] + (valorDeX - numeros[0]) * resultadosOrdem[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]) * resultadosOrdem2[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]) * (valorDeX - numeros[2]) * resultadosOrdem3[0];
            imprimirP(valorDeX, P);
        } else if (contador == 5) { // Se tiver 5 valores de x
            calcularOrdem1(numeros, numerosDaFuncao, resultadosOrdem, contador);

            Double[] resultadosOrdem2 = new Double[contador-2];
            calcularOrdem2(numeros, resultadosOrdem, contador, resultadosOrdem2);

            Double[] resultadosOrdem3 = new Double[contador-3];
            calcularOrdem3(numeros, contador, resultadosOrdem2, resultadosOrdem3);

            Double[] resultadosOrdem4 = new Double[contador-4];
            calcularOrdem4(numeros, contador, resultadosOrdem3, resultadosOrdem4);

            final double P =
                    numerosDaFuncao[0] + (valorDeX - numeros[0]) * resultadosOrdem[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]) * resultadosOrdem2[0] + (valorDeX - numeros[0]) *
                            (valorDeX - numeros[1]) * (valorDeX - numeros[2]) * resultadosOrdem3[0] +
                            (valorDeX - numeros[0]) * (valorDeX - numeros[1]) * (valorDeX - numeros[2]) *
                                    (valorDeX - numeros[3]) * resultadosOrdem4[0];
            imprimirP(valorDeX, P);
        }
    }

    private void calcularOrdem1(Double[] numeros, Double[] numerosDaFuncao, Double[] resultadosOrdem, int contador) {
        Double resultado;
        for (int i = 0; i < contador-1; i++) {
            resultado = (numerosDaFuncao[i + 1] - numerosDaFuncao[i]) / (numeros[i + 1] - numeros[i]);
            resultadosOrdem[i] = resultado;
        }
    }

    private void calcularOrdem2(Double[] numeros, Double[] resultadosOrdem, int contador, Double[] resultadosOrdem2) {
        Double resultado;
        for (int i = 0; i < contador-2; i++) {
            resultado = (resultadosOrdem[i + 1] - resultadosOrdem[i]) / (numeros[i + 2] - numeros[i]);
            resultadosOrdem2[i] = resultado;
        }
    }

    private void calcularOrdem3(Double[] numeros, int contador, Double[] resultadosOrdem2, Double[] resultadosOrdem3) {
        Double resultado;
        for (int i = 0; i < contador-3; i++) {
            resultado = (resultadosOrdem2[i + 1] - resultadosOrdem2[i] / (numeros[i + 3] - numeros[i]));
            resultadosOrdem3[i] = resultado;
        }
    }
    private void calcularOrdem4(Double[] numeros, int contador, Double[] resultadosOrdem3, Double[] resultadosOrdem4) {
        Double resultado;
        for (int i = 0; i < contador-4; i++) {
            resultado = (resultadosOrdem3[i + 1] - resultadosOrdem3[i] / numeros[i + 4] - numeros[i]);
            resultadosOrdem4[i] = resultado;
        }
    }

    private void imprimirP(double valorDeX, double p) {
        System.out.printf("P(%.4f) = %.4f", valorDeX, p);
    }

    /*public Double[] retornarResultadoD(double valorDeX, Double... numeros) {
        Double[] arrayRetorno = new Double[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            Double D = 1.0;
            if (i == 0) {
                arrayRetorno[i] = 1.0;
            }
            for (int j = 0; j < i; j++) {
                D *= (valorDeX + numeros[j]);
            }

            if (i != 0) {
                arrayRetorno[i] = D;
            }

        }

        return arrayRetorno;
    }*/
}
