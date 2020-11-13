package com.domain.bdd;

import cucumber.api.java.en.Given;
import org.assertj.core.api.Assertions;

public class StepDefinitions {

    @Given("'(.*)'")
    public void fix_me(String element) {
        Assertions.fail("not implemented");
    }
}
