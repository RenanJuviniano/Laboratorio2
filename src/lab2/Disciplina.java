package lab2;

import java.util.Arrays;

//Classe
//representa uma disciplina
public class Disciplina {

    //Atributo
    //guarda o nome da disciplina
    private String nomeDisciplina;

    //Atributo
    //guarda a quantidade de horas estudadas
    private int horasEstudo;

    //Atributo
    //guarda as notas da disciplina
    private double[] notas;

    //Atributo
    //guarda os pesos de cada nota
    private int[] pesos;

    //Construtor
    //cria uma disciplina com 4 notas
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.pesos = null;
    }

    //Construtor
    //cria uma disciplina com a quantidade de notas informada
    //Parâmetros
    //nome da disciplina e número de notas
    public Disciplina(String nomeDisciplina, int numeroDeNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = null;
    }

    //Construtor
    //cria uma disciplina com notas e pesos
    //Parâmetros
    //nome, número de notas e pesos
    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = pesos;
    }

    //Método
    //adiciona horas de estudo à disciplina
    //Parâmetro
    //quantidade de horas que será adicionada
    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    //Método
    //cadastra uma nota na disciplina
    //Parâmetros
    //número da nota e valor da nota
    public void cadastraNota(int nota, double valorNota) {

        //Condição
        //verifica se o número da nota é válido
        if (nota >= 1 && nota <= notas.length) {
            notas[nota - 1] = valorNota;
        }
    }

    //Método
    //calcula a média das notas
    private double calculaMedia() {

        //Condição
        //verifica se a disciplina não possui pesos
        if (pesos == null) {

            //Variável
            //guarda a soma das notas
            double soma = 0;

            //Laço
            //percorre todas as notas
            for (int i = 0; i < notas.length; i++) {
                soma += notas[i];
            }

            //Retorna a média das notas
            return soma / notas.length;
        }

        //Variável
        //guarda a soma das notas com seus pesos
        double soma = 0;

        //Variável
        //guarda a soma dos pesos
        int somaPesos = 0;

        //Laço
        //percorre as notas e seus pesos
        for (int i = 0; i < notas.length; i++) {

            //Calcula a nota multiplicada pelo seu peso
            soma += notas[i] * pesos[i];

            //Soma os pesos
            somaPesos += pesos[i];
        }

        //Retorna a média ponderada
        return soma / somaPesos;
    }

    //Método
    //verifica se o aluno foi aprovado
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    //Método
    //transforma as informações da disciplina em uma String
    @Override
    public String toString() {

        return nomeDisciplina
                + " "
                + horasEstudo
                + " "
                + calculaMedia()
                + " "
                + Arrays.toString(notas);
    }
}