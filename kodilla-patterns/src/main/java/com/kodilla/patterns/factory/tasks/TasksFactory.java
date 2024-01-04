package com.kodilla.patterns.factory.tasks;

public class TasksFactory {

    private static final String SHOPPING = "ShoppingTask";
    private static final String PAINTING = "PaintingTask";
    private static final String DRIVING = "DrivingTask";


    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Shopping for Christmas", "Presents", 10);
            case PAINTING -> new PaintingTask("Painting living room", "green", "walls");
            case DRIVING -> new DrivingTask("Pick up Roger", "Airport", "Car");
            default -> null;
        };
    }
}
