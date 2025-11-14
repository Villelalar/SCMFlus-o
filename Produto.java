package model;

import java.util.ArrayList;

public class Produto {

    public static final int TAM_NOME = 80;
    public static final int TAM_DESCRICAO = 200;

    private int id_produto;
    private String nome;
    private String descricao;
    private ArrayList<Item> itens;

    public Produto(int id_produto, String nome, String descricao) throws ModelException {
        setId_produto(id_produto);
        setNome(nome);
        setDescricao(descricao);
        this.itens = new ArrayList<>();
    }

    // ID Produto
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) throws ModelException {
        validarId(id_produto);
        this.id_produto = id_produto;
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

    // Itens
    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) throws ModelException {
        if (item == null)
            throw new ModelException("Item não pode ser nulo!");
        if (!this.itens.contains(item)) {
            this.itens.add(item);
            item.setProduto(this); 
        }
    }

    public void removerItem(Item item) throws ModelException {
        if (item == null)
            throw new ModelException("Item não pode ser nulo!");
        if (!this.itens.contains(item))
            throw new ModelException("Item não encontrado no produto!");
        this.itens.remove(item);
        item.setProduto(null); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id_produto).append(" - ").append(nome).append(" | ").append(descricao);
        sb.append("\nItens (").append(itens.size()).append("):");
        for (Item item : itens) {
            sb.append("\n  - ").append(item.getNome());
        }
        return sb.toString();
    }

    // Validações
    public static void validarId(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do produto deve ser > 0");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isBlank())
            throw new ModelException("Nome do produto não pode ser vazio!");

        if (nome.length() > TAM_NOME)
            throw new ModelException("Nome do produto deve ter até " + TAM_NOME + " caracteres!");
    }

    public static void validarDescricao(String descricao) throws ModelException {
        if (descricao == null || descricao.isBlank())
            throw new ModelException("Descrição do produto não pode ser vazia!");

        if (descricao.length() > TAM_DESCRICAO)
            throw new ModelException("Descrição deve ter até " + TAM_DESCRICAO + " caracteres!");
    }
}