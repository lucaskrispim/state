package org.example;

public class TarefaEstadoCancelada extends TarefaEstado {

    private TarefaEstadoCancelada() {};
    private static TarefaEstadoCancelada instance = new TarefaEstadoCancelada();
    public static TarefaEstadoCancelada getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Cancelada";
    }
}

