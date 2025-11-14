package model;

public class Agente extends Empresa {

    private int id_agente;
    private String telefone;

    public Agente(int id_empresa, String nome, String cnpj, String telefone_empresa, int id_agente, String telefone) throws ModelException {
        super(id_empresa, nome, cnpj, telefone_empresa);
        setId_agente(id_agente);
        setTelefone(telefone);
    }

    // ID Agente
    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) throws ModelException {
        validarIdAgente(id_agente);
        this.id_agente = id_agente;
    }

    // Telefone do Agente
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ModelException {
        validarTelefone(telefone);
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Agente " + id_agente + " | Tel: " + telefone + " - " + super.toString();
    }

    // Validações
    public static void validarIdAgente(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do agente deve ser > 0");
    }

    public static void validarTelefone(String telefone) throws ModelException {
        if (telefone == null || telefone.isBlank())
            throw new ModelException("Telefone do agente não pode ser vazio!");

        if (telefone.length() > 15)
            throw new ModelException("Telefone deve ter até 15 caracteres!");
    }
}