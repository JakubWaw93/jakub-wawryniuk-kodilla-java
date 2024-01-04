package com.kodilla.patterns.factory.tasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TaskFactoryTestSuite {

    @Test
    void testFactoryMakeTasks() {
        //Given
        TasksFactory tasksFactory = new TasksFactory();
        //When
        Task testShoppingTask = tasksFactory.makeTask("ShoppingTask");
        Task testPaintingTask = tasksFactory.makeTask("PaintingTask");
        Task testDrivingTask = tasksFactory.makeTask("DrivingTask");
        //Then
        assertEquals("Shopping for Christmas", testShoppingTask.getTaskName());
        assertEquals("Painting living room", testPaintingTask.getTaskName());
        assertEquals("Pick up Roger", testDrivingTask.getTaskName());
    }

    @Test
    void testExeCuteTask() {
        //Given
        TasksFactory tasksFactory = new TasksFactory();
        Task testShoppingTask = tasksFactory.makeTask("ShoppingTask");
        System.out.println(testShoppingTask.isTaskExecuted());
        //When
        testShoppingTask.executeTask();
        System.out.println(testShoppingTask.isTaskExecuted());
        //Then
        assertTrue(testShoppingTask.isTaskExecuted());

    }
}
