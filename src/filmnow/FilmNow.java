package filmnow;
/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 */
public class FilmNow {

    private static final int TAMANHO = 100;
    private static final int TAMANHO_HOTLIST = 10;

    private Filme[] filmes; //uma representacao simploria da lista de filmes
    private Filme[] hotList; //representa a lista dos filmes na HotList

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
        this.hotList = new Filme[TAMANHO_HOTLIST];
    }

    /**
     * Acessa a lista de filmes mantida.
     *
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    /**
     * Acessa os dados de um filme específico.
     *
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        if (posicao < 0 || posicao >= TAMANHO) {
            return null;
        }

        return filmes[posicao];
    }

    //onde eu comecei a mudar as coisas

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     *
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     */
    public void cadastraFilme(int posicao, String nome, String ano, String local) {
        if (posicao < 0 || posicao >= TAMANHO
                || nome == null || nome.trim().isEmpty()
                || ano == null || ano.trim().isEmpty()
                || local == null || local.trim().isEmpty()) {
            return;
        }

        Filme novoFilme = new Filme(nome, ano, local);

        for (int i = 0; i < TAMANHO; i++) {
            if (i != posicao && novoFilme.equals(this.filmes[i])) {
                return;
            }
        }

        this.filmes[posicao] = novoFilme;
    }

    /**
     * Detalha o filme de uma posição.
     *
     * @param posicao Posição do filme.
     * @return Dados do filme.
     */
    public String detalhaFilme(int posicao) {
        Filme filme = getFilme(posicao);

        if (filme == null) {
            return null;
        }

        String detalhes = filme.toString() + "\n" + filme.getLocal();

        if (filmeEstaNaHotList(filme)) {
            detalhes = detalhes + "\nFilme na HotList";
        }

        return detalhes;
    }

    /**
     * Mostrar todos os filmes cadastrados.
     *
     * @return Lista dos filmes cadastrados.
     */
    public String[] mostrarFilmes() {
        String[] lista = new String[TAMANHO];
        int quantidade = 0;

        for (int i = 0; i < TAMANHO; i++) {
            if (this.filmes[i] != null) {
                lista[quantidade] = (i + 1) + " - "
                        + this.filmes[i].toString();
                quantidade++;
            }
        }

        String[] resultado = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resultado[i] = lista[i];
        }

        return resultado;
    }

    //Hot List

    /**
     * Verifica se o filme está na HotList.
     */
    private boolean filmeEstaNaHotList(Filme filme) {
        for (int i = 0; i < TAMANHO_HOTLIST; i++) {
            if (filme.equals(this.hotList[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * HotList dos filmes.
     *
     * @param posicao Posição do filme.
     * @param posicaoHot Posição na HotList.
     * @return true se conseguiu adicionar.
     */
    //atribuirHot atribui filme a hotList.
    public boolean atribuirHotList(int posicao, int posicaoHot) {
        if (posicao < 0 || posicao >= TAMANHO
                || posicaoHot < 0
                || posicaoHot >= TAMANHO_HOTLIST) {
            return false;
        }

        Filme filme = this.filmes[posicao];

        if (filme == null || filmeEstaNaHotList(filme)) {
            return false;
        }

        this.hotList[posicaoHot] = filme;

        return true;
    }

    //remove filme da hotList.
    public boolean removeHotList(int posicao) {
        if (posicao < 0 || posicao >= TAMANHO_HOTLIST) {
            return false;
        }

        this.hotList[posicao] = null;

        return true;
    }

    //filmeshotlist mostra os filmes da HotList.
    public String[] filmesHotList() {
        String[] lista = new String[TAMANHO_HOTLIST];
        int quantidade = 0;

        for (int i = 0; i < TAMANHO_HOTLIST; i++) {
            if (this.hotList[i] != null) {
                lista[quantidade] = (i + 1) + " - "
                        + this.hotList[i].toString();
                quantidade++;
            }
        }

        String[] resultado = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resultado[i] = lista[i];
        }

        return resultado;
    }
}