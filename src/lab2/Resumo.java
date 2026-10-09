package lab2;

//Classe
//representa um resumo
public class Resumo {

    //Atributo
    //guarda o tema do resumo
    private String tema;

    //Atributo
    //guarda o conteúdo do resumo
    private String conteudo;

    //Construtor
    //cria um resumo com tema e conteúdo
    //Parâmetros
    //tema e conteúdo do resumo
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    //Método
    //retorna o tema do resumo
    public String getTema() {
        return tema;
    }

    //Método
    //retorna o conteúdo do resumo
    public String getConteudo() {
        return conteudo;
    }
}