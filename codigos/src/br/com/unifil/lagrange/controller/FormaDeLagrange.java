package br.com.unifil.lagrange.controller;

public class FormaDeLagrange {

    private double resultado = 0.0;
//    private double[] valoresDaFuncao;

    public void interpolarPontos(double x, Double[] numeros, Double[] valoresDaFuncao) {
        Double[] valoresDoX = new Double[numeros.length];
        adicionarElementosNoArray(valoresDoX, numeros);
//        valoresDaFuncao = calcularFuncaoDoValorX(valoresDoX);

        Double[] valoresDeL = retornarResultadoL(x, valoresDoX);
        imprimirLista(valoresDoX, "VALORES_X");
        imprimirLista(valoresDaFuncao, "VALORES_FUNCAO");

        for (int i = 0; i < valoresDeL.length; i++) {
            resultado += (valoresDeL[i] * valoresDaFuncao[i]);
        }

        System.out.println("Resultado: " + getResultado());
    }

    /*private double[] calcularFuncaoDoValorX(double... valores) {
        double e = Math.E;
        double[] resultadoDaFuncao = new double[valores.length];
        for (int i = 0; i < valores.length; i++) {
            resultadoDaFuncao[i] = Math.pow(e, (2 * valores[i]));
        }
        return resultadoDaFuncao;
    }*/

    private void adicionarElementosNoArray(Double[] arrayACarregar, Double[] arrayCarregado) {
        for (int i = 0; i < arrayCarregado.length; i++) {
            arrayACarregar[i] = arrayCarregado[i];
        }
    }

    private Double[] retornarResultadoL(double x, Double... numeros) {
        Double[] array = new Double[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            double L = 1.0;
            for (int j = 0; j < numeros.length; j++) {
                if (i != j) {
                    L *= ((x - numeros[j]) / (numeros[i] - numeros[j]));
                }
            }
            array[i] = L;
        }
        return array;
    }
    
    public double getResultado() {
        return resultado;
    }

    /*public double[] getValoresDaFuncao() {
        return valoresDaFuncao;
    }*/

    private void imprimirLista(Double[] lista, String nomeDaLista) {
        for (int i = 0; i < lista.length; i++) {
            if (i == 0 && nomeDaLista.toUpperCase().equals("VALORES_X")) {
                for (int j = 0; j < lista.length; j++) {
                    if (j == 0) {
                        System.out.printf("%27d | ", j);
                    }
                    if (j >= 1) {
                        System.out.printf("%12d | ", j);
                    }
                }
                System.out.println();
            }

            if (i == 0 && nomeDaLista.toUpperCase().equals("VALORES_X")) {
                System.out.printf("%12s | ", "X");
            }
            if (i == 0 && nomeDaLista.toUpperCase().equals("VALORES_FUNCAO")) {
                System.out.printf("%12s | ", "F(x)");
            }
            System.out.printf("%12f | ", lista[i]);
        }
        System.out.println();
    }
    
}
