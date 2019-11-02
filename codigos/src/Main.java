import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Inserir os valores:");
        System.out.print("Número 1: ");
        double numero1 = teclado.nextDouble();
        System.out.print("Número 2: ");
        double numero2 = teclado.nextDouble();
        System.out.print("Número 3: ");
        double numero3 = teclado.nextDouble();
        System.out.print("Valor do x: ");
        double x = teclado.nextDouble(); teclado.nextLine();

        Lagrange lagrange = new Lagrange(numero1, numero2, numero3);
        lagrange.interpolarPontos(x, numero1, numero2, numero3);
    }

}
