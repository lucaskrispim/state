package org.example;

public class TarefaEstadoPendente extends TarefaEstado {

    private TarefaEstadoPendente() {};
    private static TarefaEstadoPendente instance = new TarefaEstadoPendente();
    public static TarefaEstadoPendente getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pendente";
    }

    public boolean iniciar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        return true;
    }

    public boolean cancelar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        return true;
    }
}
