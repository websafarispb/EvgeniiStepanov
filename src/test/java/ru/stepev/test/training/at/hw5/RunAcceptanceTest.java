package ru.stepev.test.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features")
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
