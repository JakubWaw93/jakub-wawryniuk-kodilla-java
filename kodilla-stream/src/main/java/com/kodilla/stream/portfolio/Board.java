package com.kodilla.stream.portfolio;


import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList){
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList){
        return taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Board.class.getSimpleName() + "[", "]")
                .add("taskLists=" + taskLists)
                .add("name='" + name + "'")
                .toString();
    }
}
