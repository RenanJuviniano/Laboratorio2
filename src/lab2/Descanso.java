package lab2;

//Classe
//Descanso
public class Descanso {

    //Atributo
    //guarda as horas de descanso
    private int horasDescanso;

    //Atributo
    //guarda o número de semanas
    private int numeroSemanas;

    //Construtor
    //inicia os atributos com 0
    public Descanso() {
        horasDescanso = 0;
        numeroSemanas = 0;
    }

    //Método
    //define as horas de descanso
    //Parâmetro
    //valor que será colocado no atributo
    public void defineHorasDescanso(int valor) {
        horasDescanso = valor;
    }

    //Método
    //define o número de semanas
    //Parâmetro
    //valor que será colocado no atributo
    public void defineNumeroSemanas(int valor) {
        numeroSemanas = valor;
    }

    //Método
    //verifica se o aluno está descansado
    public String getStatusGeral() {

        //Condição
        //verifica se algum valor ainda é 0
        if (horasDescanso == 0 || numeroSemanas == 0) {
            return "cansado";
        }

        //Variável
        //calcula a média de horas por semana
        double media = (double) horasDescanso / numeroSemanas;

        //Condição
        //verifica se a média é pelo menos 26
        if (media >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}