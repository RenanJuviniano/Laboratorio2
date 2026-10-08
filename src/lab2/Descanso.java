package lab2;

public class Descanso {

    private int horasDescanso;
    private int numeroSemanas;

    public Descanso() {
        horasDescanso = 0;
        numeroSemanas = 0;
    }

    public void defineHorasDescanso(int valor) {
        horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        numeroSemanas = valor;
    }

    public String getStatusGeral() {
        if (horasDescanso == 0 || numeroSemanas == 0) {
            return "cansado";
        }

        double media = (double) horasDescanso / numeroSemanas;

        if (media >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}