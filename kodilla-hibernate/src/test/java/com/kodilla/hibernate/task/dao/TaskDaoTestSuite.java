package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TasksDao tasksDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);

        //When
        tasksDao.save(task);

        //Then
        int id = task.getId();
        Optional<Task> readTask = tasksDao.findById(id);
        assertTrue(readTask.isPresent());

        //Cleanup
        tasksDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        tasksDao.save(task);
        int duration = task.getDuration();

        //When
        List<Task> readTask = tasksDao.findByDuration(duration);

        //Then
        assertEquals(4, readTask.size());

        //CleanUp
        int id = readTask.get(0).getId();
        tasksDao.deleteById(id);
        tasksDao.deleteAll();
    }
}
