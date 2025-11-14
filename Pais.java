package model;

public class Pais {

    public static final int TAM_NOME = 40;

    private int id_pais;
    private String nome;

    public Pais(int id_pais, String nome) throws ModelException {
        setId_pais(id_pais);
        setNome(nome);
    }

    // ID
    public int getId_pais() { 
        return id_pais; 
    }

    public void setId_pais(int id_pais) throws ModelException {
        validarId(id_pais);
        this.id_pais = id_pais;
    }

    // Nome
    public String getNome() {
        return nome; 
    }

    public void setNome(String nome) throws ModelException {
        validarNome(nome);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return id_pais + " - " + nome;
    }

    // Validações
    public static void validarId(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do país deve ser > 0");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome do país não pode ser vazio!");

        if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+"))
            throw new ModelException("O nome do país deve ter apenas letras!");

        if (nome.length() > TAM_NOME)
            throw new ModelException("Nome do país deve ter até " + TAM_NOME + " caracteres!");
    }
}