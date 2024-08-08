package StepDefinition;

import io.cucumber.java.Before;
import org.testng.annotations.BeforeTest;
/// hook file contains pre-requisites configuration.
public class Hooks {

    @Before("applicationSetup")
    public void setUp()
    {

    }

}
