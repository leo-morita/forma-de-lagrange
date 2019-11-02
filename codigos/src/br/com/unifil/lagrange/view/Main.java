package br.com.unifil.lagrange.view;

import br.com.unifil.lagrange.controller.Lagrange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Double> valoresDeX = new ArrayList<>();

        System.out.println("Inserir os valores:");
        System.out.print("Inserir a quantidade de pontos: ");
        int quantidadeDePontos = teclado.nextInt();

        for (int i = 1; i <= quantidadeDePontos; i++) {
            System.out.printf("Número %d: ", i);
            double valorX = teclado.nextDouble();
            valoresDeX.add(valorX);
        }

        System.out.print("Valor do x que vai ser calculado na função: ");
        double x = teclado.nextDouble(); teclado.nextLine();

        Lagrange lagrange = new Lagrange();

        Double[] arrayDosValoresX = new Double[valoresDeX.size()];
        for (int i = 0; i < valoresDeX.size(); i++) {
            arrayDosValoresX[i] = valoresDeX.get(i);
        }

        lagrange.interpolarPontos(x, arrayDosValoresX);
    }

}
