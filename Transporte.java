package model;

public class Transporte extends Empresa {

    private int id_transporte;
    private Armazem armazemOrigem;
    private Armazem armazemDestino;
    private Agente agenteResponsavel;

    public Transporte(int id_empresa, String nome, String cnpj, String telefone, 
                      int id_transporte, Armazem armazemOrigem, Armazem armazemDestino, 
                      Agente agenteResponsavel) throws ModelException {
        super(id_empresa, nome, cnpj, telefone);
        setId_transporte(id_transporte);
        setArmazemOrigem(armazemOrigem);
        setArmazemDestino(armazemDestino);
        setAgenteResponsavel(agenteResponsavel);
    }

    // ID Transporte
    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) throws ModelException {
        validarIdTransporte(id_transporte);
        this.id_transporte = id_transporte;
    }

    // Armazém Origem
    public Armazem getArmazemOrigem() {
        return armazemOrigem;
    }

    public void setArmazemOrigem(Armazem armazemOrigem) throws ModelException {
        validarArmazem(armazemOrigem, "origem");
        this.armazemOrigem = armazemOrigem;
    }

    // Armazém Destino
    public Armazem getArmazemDestino() {
        return armazemDestino;
    }

    public void setArmazemDestino(Armazem armazemDestino) throws ModelException {
        validarArmazem(armazemDestino, "destino");
        this.armazemDestino = armazemDestino;
    }

    // Agente Responsável
    public Agente getAgenteResponsavel() {
        return agenteResponsavel;
    }

    public void setAgenteResponsavel(Agente agenteResponsavel) throws ModelException {
        validarAgente(agenteResponsavel);
        this.agenteResponsavel = agenteResponsavel;
    }

    @Override
    public String toString() {
        return "Transporte " + id_transporte + " - " + super.toString() + 
               "\nOrigem: " + armazemOrigem.getNome_armazem() + 
               " | Destino: " + armazemDestino.getNome_armazem() +
               "\nAgente: " + agenteResponsavel.getId_agente();
    }

    // Validações
    public static void validarIdTransporte(int id) throws ModelException {
        if (id <= 0)
            throw new ModelException("ID do transporte deve ser > 0");
    }

    public static void validarArmazem(Armazem armazem, String tipo) throws ModelException {
        if (armazem == null)
            throw new ModelException("Armazém de " + tipo + " não pode ser nulo!");
    }

    public static void validarAgente(Agente agente) throws ModelException {
        if (agente == null)
            throw new ModelException("Agente responsável não pode ser nulo!");
    }
}