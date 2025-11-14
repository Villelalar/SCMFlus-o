
package model;

public class Armazem extends Cidade {

    public static final int TAM_NOME_ARMAZEM = 80;
    public static final int TAM_ENDERECO = 150;

    private int id_armazem;
    private String nome_armazem;
    private String endereco;

    public Armazem(int id_pais, String nome_pais, int id_cidade, String nome_cidade, 
                   int id_armazem, String nome_armazem, String endereco) throws ModelException {
        super(id_pais, nome_pais, id_cidade, nome_cidade);
        setId_armazem(id_armazem);
        setNome_armazem(nome_armazem);
        setEndereco(endereco);
    }

    // ID Armazém
    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) throws ModelException {
        validarIdArmazem(id_armazem);
        this.id_armazem = id_armazem;
    }

    // Nome Armazém
    public String getNome_armazem() {
        return nome_armazem;
    }

    public void setNome_armazem(String nome_armazem) throws ModelException {
        validarNomeArmazem(nome_armazem);
        this.nome_armazem = nome_armazem;
    }

    // Endereço
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws ModelException {
        validarEndereco(endereco);
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id_armazem + " - " + nome_armazem + " | " + endereco + " (" + super.toString() + ")";
    }

    // Validações
    public static void validarIdArmazem(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do armazém deve ser > 0");
    }

    public static void validarNomeArmazem(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome do armazém não pode ser vazio!");

        if (nome.length() > TAM_NOME_ARMAZEM)
            throw new ModelException("Nome do armazém deve ter até " + TAM_NOME_ARMAZEM + " caracteres!");
    }

    public static void validarEndereco(String endereco) throws ModelException {
        if (endereco == null || endereco.isBlank())
            throw new ModelException("Endereço do armazém não pode ser vazio!");

        if (endereco.length() > TAM_ENDERECO)
            throw new ModelException("Endereço deve ter até " + TAM_ENDERECO + " caracteres!");
    }
}