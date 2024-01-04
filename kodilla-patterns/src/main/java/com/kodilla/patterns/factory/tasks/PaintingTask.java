package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean completed = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        this.completed = true;
        System.out.println("Executing painting task...");
    }
    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return completed;
    }
}
