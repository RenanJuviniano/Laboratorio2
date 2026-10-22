package lab2;

public class RegistroResumos {

    private String[] temas;
    private String[] conteudos;
    private int quantidade;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        temas = new String[numeroDeResumos];
        conteudos = new String[numeroDeResumos];
        quantidade = 0;
        proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo) {

        if (temTemResumo(tema)) {
            return;
        }

        temas[proximaPosicao] = tema;
        conteudos[proximaPosicao] = conteudo;

        if (quantidade < temas.length) {
            quantidade++;
        }

        proximaPosicao++;

        if (proximaPosicao >= temas.length) {
            proximaPosicao = 0;
        }
    }

    private boolean temTemResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            if (temas[i] != null && temas[i].equals(tema)) {
                return true;
            }
        }

        return false;
    }

    public String[] pegaResumos() {
        String[] resumos = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }

        return resumos;
    }

    public String imprimeResumos() {
        String resultado = "- " + quantidade + " resumo(s) cadastrado(s)\n";

        if (quantidade > 0) {
            resultado += "- ";

            for (int i = 0; i < quantidade; i++) {
                resultado += temas[i];

                if (i < quantidade - 1) {
                    resultado += " | ";
                }
            }
        }

        return resultado;
    }

    public int conta() {
        return quantidade;
    }

    public boolean temResumo(String tema) {
        return temTemResumo(tema);
    }
}