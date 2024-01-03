package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    void testTaskAdd() {
        //Given

        //When
        addTask(board.getToDoList(), "Make a dinner");
        addTask(board.getInProgressList(),"Study");
        addTask(board.getDoneList(),"Go for a walk");

        //Then
        System.out.println(board.getToDoList().getTasks());
        System.out.println(board.getInProgressList().getTasks());
        System.out.println(board.getDoneList().getTasks());
    }

    private void addTask(TaskList list, String task) {
        list.getTasks().add(task);
    }

}
