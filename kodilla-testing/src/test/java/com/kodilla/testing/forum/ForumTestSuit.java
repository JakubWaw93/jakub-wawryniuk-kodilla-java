package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuit {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
        System.out.println();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
        System.out.println();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }



    @DisplayName("when create SimpleUser with realName, " +
            "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName(){

        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Doe");

        //When
        String result = simpleUser.getRealName();
        String expectedResult = "John Doe";
        System.out.println("Testing " + result);

        //Then
        Assertions.assertEquals(result, expectedResult);
    }

    @DisplayName(
            "When created SimpleUser with name, " +
            "then getUsername should return correct name"
    )
    @Test
    void testCaseUserName(){

        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        //When
        String result = simpleUser.getUserName();
        String expectedResult = "theForumUser";
        System.out.println("Testing " + result);

        //Then
        Assertions.assertEquals(result, expectedResult);
    }
}
