package filmnow;

/**
 * Representa um filme cadastrado no sistema FilmNow.
 */
public class Filme {

    // Nome do filme.
    private String nome;

    // Ano de lançamento do filme.
    private String ano;

    // Local onde o filme pode ser assistido.
    private String local;

    /**
     * Cria um filme com nome, ano e local onde pode ser assistido.
     *
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assistido.
     */
    public Filme(String nome, String ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    /**
     * Acessa o local onde o filme pode ser assistido.
     *
     * @return Local onde o filme pode ser assistido.
     */
    public String getLocal() {
        return this.local;
    }

    /**
     * Retorna os dados principais do filme.
     *
     * @return Nome e ano do filme.
     */
    @Override
    public String toString() {
        return this.nome + ", " + this.ano;
    }

    /**
     * Verifica se dois filmes são iguais pelo nome e ano.
     *
     * @param outro Objeto que será comparado com o filme.
     * @return true se os filmes tiverem o mesmo nome e ano.
     */
    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }

        if (!(outro instanceof Filme)) {
            return false;
        }

        Filme filme = (Filme) outro;

        return this.nome.equals(filme.nome)
                && this.ano.equals(filme.ano);
    }

    /**
     * Gera um código numérico baseado no nome e ano do filme.
     *
     * @return Código hash do filme.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.nome, this.ano);
    }
}
