package lab2;

import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
    }

    public void cadastraHoras(int horas) {
        horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
            notas[nota - 1] = valorNota;
        }
    }

    public boolean aprovado() {
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        double media = soma / 4;

        return media >= 7.0;
    }

    @Override
    public String toString() {
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        double media = soma / 4;

        return nomeDisciplina + " " + horasEstudo + " " + media + " " + Arrays.toString(notas);
        //mais notas na disciplina
    }
}