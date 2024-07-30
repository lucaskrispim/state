package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    Tarefa tarefa;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa("Descrição da Tarefa");
    }

    // Tarefa pendente

    @Test
    public void deveIniciarTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertTrue(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveConcluirTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void deveCancelarTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    // Tarefa em progresso

    @Test
    public void naoDeveIniciarTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertFalse(tarefa.iniciar());
    }

    @Test
    public void deveConcluirTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.concluir());
        assertEquals(TarefaEstadoConcluida.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    // Tarefa concluída

    @Test
    public void naoDeveIniciarTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.iniciar());
    }

    @Test
    public void naoDeveConcluirTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.cancelar());
    }

    // Tarefa cancelada

    @Test
    public void naoDeveIniciarTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.iniciar());
    }

    @Test
    public void naoDeveConcluirTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.cancelar());
    }

    @Test
    public void deveLancarExcecaoParaDescricaoNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Tarefa(null);
        });

        String expectedMessage = "Descrição não pode ser nula ou vazia";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void deveLancarExcecaoParaDescricaoVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Tarefa("");
        });

        String expectedMessage = "Descrição não pode ser nula ou vazia";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}