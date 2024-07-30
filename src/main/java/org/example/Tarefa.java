package org.example;

public class Tarefa {

    private String descricao;
    private TarefaEstado estado;

    public Tarefa(String descricao) {
        this.setDescricao(descricao);
        this.setEstado(TarefaEstadoPendente.getInstance());
    }

    public void setEstado(TarefaEstado estado) {
        this.estado = estado;
    }

    public boolean iniciar() {
        return estado.iniciar(this);
    }

    public boolean concluir() {
        return estado.concluir(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        this.descricao = descricao;
    }

    public TarefaEstado getEstado() {
        return estado;
    }
}
