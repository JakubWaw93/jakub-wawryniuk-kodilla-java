package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;
    static final String DESCRIPTION = "Now, let's do it again with more confidence!";
    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("First task.", DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        int iD = taskList.getId();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listName);

        //Then
        assertEquals(1, readTaskList.size());
        assertEquals(DESCRIPTION, readTaskList.get(0).getDescription());

        //CleanUp
        taskListDao.deleteById(iD);
    }
}
