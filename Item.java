package model;
public class Item {

    public static final int TAM_NOME = 80;
    public static final int TAM_DESCRICAO = 200;

    private int id_item;
    private String nome;
    private String descricao;
    private Produto produto;

    public Item(int id_item, String nome, String descricao) throws ModelException {
        setId_item(id_item);
        setNome(nome);
        setDescricao(descricao);
    }

    // ID Item
    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) throws ModelException {
        validarId(id_item);
        this.id_item = id_item;
    }

    // Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        validarNome(nome);
        this.nome = nome;
    }

    // Descrição
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws ModelException {
        validarDescricao(descricao);
        this.descricao = descricao;
    }

    // Produto (Composição)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        String produtoInfo = (produto != null) ? " | Produto: " + produto.getNome() : "";
        return id_item + " - " + nome + " | " + descricao + produtoInfo;
    }

    // Validações
    public static void validarId(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do item deve ser > 0");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome do item não pode ser vazio!");

        if (nome.length() > TAM_NOME)
            throw new ModelException("Nome do item deve ter até " + TAM_NOME + " caracteres!");
    }

    public static void validarDescricao(String descricao) throws ModelException {
        if (descricao == null || descricao.isBlank())
            throw new ModelException("Descrição do item não pode ser vazia!");

        if (descricao.length() > TAM_DESCRICAO)
            throw new ModelException("Descrição deve ter até " + TAM_DESCRICAO + " caracteres!");
    }
}