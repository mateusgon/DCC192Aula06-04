package br.ufjf.dcc192;


import br.ufjf.dcc192.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private static List<Tarefa> tarefas;
    public static List<Tarefa> getInstance()
    {
        if (tarefas == null)
        {
            tarefas = new ArrayList<>();
            tarefas.add(new Tarefa("Estudar Java", "Sintaxe básica da Linguagem"));
            tarefas.add(new Tarefa("Estudar Servlets", "Modelo requisição-reposta"));
            tarefas.add(new Tarefa("Estudar JSP", "Linguagem de marcação dinâmica"));
        }
            return tarefas;
    }
}
