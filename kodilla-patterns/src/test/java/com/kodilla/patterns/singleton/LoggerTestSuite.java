package com.kodilla.patterns.singleton;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void initializeLogger() {
        logger = Logger.INSTANCE;
        logger.log("myapp.open");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String log = logger.getLastLog();
        //Then
        assertEquals("myapp.open", log);
    }

}
