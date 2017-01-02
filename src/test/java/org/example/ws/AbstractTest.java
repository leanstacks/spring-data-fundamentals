package org.example.ws;

import org.example.ws.util.RequestContext;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The AbstractTest class is the parent of all JUnit test classes. This class
 * configures the test ApplicationContext and test runner environment.
 * 
 * @author Matt Warman
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Application.class)
public abstract class AbstractTest {

    /**
     * The Account.username attribute value used by default for unit tests.
     */
    public static final String USERNAME = "unittest";

    /**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Prepares the test class for execution.
     */
    protected void setUp() {

        RequestContext.setUsername(AbstractTest.USERNAME);

    }

}
