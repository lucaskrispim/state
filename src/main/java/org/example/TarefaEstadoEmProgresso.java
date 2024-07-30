package org.example;

public class TarefaEstadoEmProgresso extends TarefaEstado {

    private TarefaEstadoEmProgresso() {};
    private static TarefaEstadoEmProgresso instance = new TarefaEstadoEmProgresso();
    public static TarefaEstadoEmProgresso getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Progresso";
    }

    public boolean concluir(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        return true;
    }

    public boolean cancelar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        return true;
    }
}

