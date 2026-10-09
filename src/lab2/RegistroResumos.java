package lab2;

import java.util.Arrays;

//Classe
//gerencia os resumos cadastrados
public class RegistroResumos {

    //Atributo
    //guarda os objetos Resumo
    private Resumo[] resumos;

    //Atributo
    //guarda a quantidade de resumos cadastrados
    private int quantidade;

    //Atributo
    //indica a próxima posição onde será colocado um resumo
    private int proximaPosicao;

    //Construtor
    //cria o registro com a quantidade máxima de resumos
    //Parâmetro
    //número máximo de resumos
    public RegistroResumos(int numeroDeResumos) {
        resumos = new Resumo[numeroDeResumos];
        quantidade = 0;
        proximaPosicao = 0;
    }

    //Método
    //adiciona um novo resumo
    //Parâmetros
    //tema e conteúdo do resumo
    public void adiciona(String tema, String conteudo) {

        //Condição
        //verifica se o tema já foi cadastrado
        if (temResumo(tema)) {
            return;
        }

        //Cria um novo objeto Resumo na próxima posição
        resumos[proximaPosicao] = new Resumo(tema, conteudo);

        //Aumenta a quantidade de resumos cadastrados
        if (quantidade < resumos.length) {
            quantidade++;
        }

        //Passa para a próxima posição
        proximaPosicao++;

        //Se chegar ao final do array, volta para a primeira posição
        if (proximaPosicao >= resumos.length) {
            proximaPosicao = 0;
        }
    }

    //Método
    //retorna os resumos cadastrados em forma de String
    public String[] pegaResumos() {

        //Variável
        //cria um array para guardar os resumos
        String[] resultado = new String[quantidade];

        //Laço
        //percorre os resumos cadastrados
        for (int i = 0; i < quantidade; i++) {
            resultado[i] = resumos[i].getTema()
                    + ": "
                    + resumos[i].getConteudo();
        }

        //Retorna o array com os resumos
        return resultado;
    }

    //Método
    //monta uma String com os temas dos resumos
    public String imprimeResumos() {

        //Variável
        //começa a montar o texto com a quantidade de resumos
        String resultado =
                "- " + quantidade + " resumo(s) cadastrado(s)\n";

        //Condição
        //verifica se existe pelo menos um resumo
        if (quantidade > 0) {

            resultado += "- ";

            //Laço
            //percorre os temas dos resumos
            for (int i = 0; i < quantidade; i++) {

                resultado += resumos[i].getTema();

                //Coloca o separador entre os temas
                if (i < quantidade - 1) {
                    resultado += " | ";
                }
            }
        }

        //Retorna o texto montado
        return resultado;
    }

    //Método
    //retorna a quantidade de resumos cadastrados
    public int conta() {
        return quantidade;
    }

    //Método
    //verifica se já existe um resumo com determinado tema
    //Parâmetro
    //tema que será procurado
    public boolean temResumo(String tema) {

        //Laço
        //percorre os resumos cadastrados
        for (int i = 0; i < quantidade; i++) {

            //Condição
            //verifica se o tema é igual ao informado
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        //Retorna false caso o tema não seja encontrado
        return false;
    }

    //Método
    //busca os temas que possuem a palavra no conteúdo
    //Parâmetro
    //palavra que será procurada
    public String[] busca(String chaveDeBusca) {

        //Array
        //guarda os temas encontrados
        String[] encontrados = new String[quantidade];

        //Variável
        //conta quantos temas foram encontrados
        int quantidadeEncontrados = 0;

        //Laço
        //percorre todos os resumos
        for (int i = 0; i < quantidade; i++) {

            //Verifica o conteúdo ignorando maiúsculas e minúsculas
            if (resumos[i].getConteudo()
                    .toLowerCase()
                    .contains(chaveDeBusca.toLowerCase())) {

                //Guarda o tema do resumo encontrado
                encontrados[quantidadeEncontrados] =
                        resumos[i].getTema();

                quantidadeEncontrados++;
            }
        }

        //Diminui o array para ficar apenas com os encontrados
        encontrados = Arrays.copyOf(encontrados, quantidadeEncontrados);

        //Ordena os temas em ordem alfabética
        Arrays.sort(encontrados);

        //Retorna os temas encontrados
        return encontrados;
    }
}