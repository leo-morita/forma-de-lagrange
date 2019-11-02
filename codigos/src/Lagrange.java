import com.sun.org.apache.regexp.internal.RE;

public class Lagrange {
    private double numero0;
    private double numero1;
    private double numero2;

    public Lagrange(double numero0, double numero1, double numero2) {
        this.numero0 = numero0;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public void interpolarPontos(double x, double numero0, double numero1, double numero2) {
        final double LO = ((x - numero1) / (numero0 - numero1)) * ((x - numero2) / (numero0 - numero2));
        final double L1 = ((x - numero0) / (numero1 - numero0)) * ((x - numero2) / (numero1 - numero2));
        final double L2 = ((x - numero0) / (numero2 - numero0)) * ((x - numero1) / (numero2 - numero1));

        final double RESULTADO = ((LO * 1.221) + (L1 * 3.32) + (L2 * 4.953));

        System.out.println("Valor do L0: " + LO);
        System.out.println("Valor do L1: " + L1);
        System.out.println("Valor do L2: " + L2);
        System.out.printf("Resultado do P(%f): %f", x, RESULTADO);
    }

    public void interpolarPontos(double x, double numero0, double numero1) {
        final double LO = ((x - numero1) / (numero0 - numero1)) * ((x - numero0) / (numero1 - numero0));

        System.out.println("Valor do x: " + LO);
    }
}
