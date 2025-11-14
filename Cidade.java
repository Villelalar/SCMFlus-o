package model;

public class Cidade extends Pais {

    public static final int TAM_NOME_CIDADE = 60;

    private int id_cidade;
    private String nome_cidade;

    public Cidade(int id_pais, String nome_pais, int id_cidade, String nome_cidade) throws ModelException {
        super(id_pais, nome_pais);
        setId_cidade(id_cidade);
        setNome_cidade(nome_cidade);
    }

    // ID Cidade
    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) throws ModelException {
        validarIdCidade(id_cidade);
        this.id_cidade = id_cidade;
    }

    // Nome Cidade
    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) throws ModelException {
        validarNomeCidade(nome_cidade);
        this.nome_cidade = nome_cidade;
    }

    @Override
    public String toString() {
        return id_cidade + " - " + nome_cidade + " (" + super.toString() + ")";
    }

    // Validações
    public static void validarIdCidade(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID da cidade deve ser > 0");
    }

    public static void validarNomeCidade(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome da cidade não pode ser vazio!");

        if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+"))
            throw new ModelException("O nome da cidade deve ter apenas letras!");

        if (nome.length() > TAM_NOME_CIDADE)
            throw new ModelException("Nome da cidade deve ter até " + TAM_NOME_CIDADE + " caracteres!");
    }
}