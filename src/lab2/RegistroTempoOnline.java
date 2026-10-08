package lab2;

public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        tempoOnline += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoEsperado;
    }

    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoEsperado;
    }
}