package model;

public class Empresa {

    public static final int TAM_NOME = 100;
    public static final int TAM_CNPJ = 18;
    public static final int TAM_TELEFONE = 15;

    private int id_empresa;
    private String nome;
    private String cnpj;
    private String telefone;

    public Empresa(int id_empresa, String nome, String cnpj, String telefone) throws ModelException {
        setId_empresa(id_empresa);
        setNome(nome);
        setCnpj(cnpj);
        setTelefone(telefone);
    }

    // ID Empresa
    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) throws ModelException {
        validarId(id_empresa);
        this.id_empresa = id_empresa;
    }

    // Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        validarNome(nome);
        this.nome = nome;
    }

    // CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws ModelException {
        validarCnpj(cnpj);
        this.cnpj = cnpj;
    }

    // Telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ModelException {
        validarTelefone(telefone);
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return id_empresa + " - " + nome + " | CNPJ: " + cnpj + " | Tel: " + telefone;
    }

    // Validações
    public static void validarId(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID da empresa deve ser > 0");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome da empresa não pode ser vazio!");

        if (nome.length() > TAM_NOME)
            throw new ModelException("Nome da empresa deve ter até " + TAM_NOME + " caracteres!");
    }

    public static void validarCnpj(String cnpj) throws ModelException {
        if (cnpj == null || cnpj.isBlank())
            throw new ModelException("CNPJ não pode ser vazio!");

        if (cnpj.length() > TAM_CNPJ)
            throw new ModelException("CNPJ deve ter até " + TAM_CNPJ + " caracteres!");
    }

    public static void validarTelefone(String telefone) throws ModelException {
        if (telefone == null || telefone.isBlank())
            throw new ModelException("Telefone não pode ser vazio!");

        if (telefone.length() > TAM_TELEFONE)
            throw new ModelException("Telefone deve ter até " + TAM_TELEFONE + " caracteres!");
    }
}