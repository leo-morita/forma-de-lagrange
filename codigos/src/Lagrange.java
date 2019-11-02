public class Lagrange {

    public void interpolarPontos(double x, Double[] numeros) {
        double[] valoresDoX = new double[numeros.length];
        adicionarElementosNoArray(valoresDoX, numeros);
        double[] valoresDaFuncao = calcularFuncaoDoValorX(valoresDoX);

        double[] valoresDeL = retornarResultadoL(x, valoresDoX);
        double resultado = 0.0;

        for (int i = 0; i < valoresDeL.length; i++) {
            resultado += (valoresDeL[i] * valoresDaFuncao[i]);
        }
        System.out.println("Resultado: " + resultado);
    }

    public void interpolarPontos2(double x, double numero0, double numero1, double numero2) {
        final double LO = ((x - numero1) / (numero0 - numero1)) * ((x - numero2) / (numero0 - numero2));
        final double L1 = ((x - numero0) / (numero1 - numero0)) * ((x - numero2) / (numero1 - numero2));
        final double L2 = ((x - numero0) / (numero2 - numero0)) * ((x - numero1) / (numero2 - numero1));

        final double RESULTADO = ((LO * 1.221) + (L1 * 3.32) + (L2 * 4.953));

        System.out.println("Valor do L0: " + LO);
        System.out.println("Valor do L1: " + L1);
        System.out.println("Valor do L2: " + L2);
        System.out.printf("Resultado do P(%f): %f", x, RESULTADO);
    }

    private double[] calcularFuncaoDoValorX(double... valores) {
        double e = Math.E;
        double[] resultadoDaFuncao = new double[valores.length];
        for (int i = 0; i < valores.length; i++) {
            resultadoDaFuncao[i] = Math.pow(e, (2 * valores[i]));
        }
        return resultadoDaFuncao;
    }

    private void adicionarElementosNoArray(double[] arrayACarregar, Double[] arrayCarregado) {
        for (int i = 0; i < arrayCarregado.length; i++) {
            arrayACarregar[i] = arrayCarregado[i];
        }
    }

    private double[] retornarResultadoL(double x, double... numeros) {
        double[] array = new double[numeros.length];
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
}