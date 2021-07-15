package ru.stepev.test.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import ru.stepev.test.training.at.hw5.model.User;
import ru.stepev.test.training.at.hw5.model.page.Page;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJDiGitHubSite() {
        fluentHomePage.open(Page.pageURL);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void loginAsUser() {
        fluentHomePage.login(User.builder().name("Roman")
                      .password("Jdi1234").build());
    }
}
