package lab2;

//Classe
//responsável por registrar o tempo online em uma disciplina
public class RegistroTempoOnline {

    //Atributo
    //guarda o nome da disciplina
    private String nomeDisciplina;

    //Atributo
    //guarda o tempo que já foi estudado online
    private int tempoOnline;

    //Atributo
    //guarda o tempo esperado de estudo
    private int tempoEsperado;

    //Construtor
    //cria o registro usando o tempo esperado padrão de 120 minutos
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoEsperado = 120;
    }

    //Construtor
    //cria o registro recebendo o tempo esperado
    //Parâmetro
    //nome da disciplina e tempo esperado
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoEsperado = tempoOnlineEsperado;
    }

    //Método
    //adiciona o tempo estudado ao tempo online
    //Parâmetro
    //quantidade de tempo que será adicionada
    public void adicionaTempoOnline(int tempo) {
        tempoOnline += tempo;
    }

    //Método
    //verifica se o tempo esperado já foi atingido
    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoEsperado;
    }

    //Método
    //transforma as informações do objeto em uma String
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoEsperado;
    }
}