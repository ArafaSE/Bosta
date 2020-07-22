package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.TestBase;

public class Hooks extends TestBase{
    @Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
    }

    @After
    public void afterScenario(){

    }
}
