package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber/cucumber.html", "summary"}  //generate an html report in html format and print missing step defination
        ,features = {"src/test/resources"}                                   //feature file path not require if within same package
        ,glue = {"com.qa.stepdef"}                                           //feature file path not require if within same package
        ,snippets = CAMELCASE                                                //format of summary or missing steps
        ,dryRun = false                                                       //Check all feature have corresponding step defination
        ,monochrome = true                                                   //Make console output from Cucumber in a readable format,
        //   ,tags = {"@foo", "not @bar"}                                       //Only Run the scenarios specified with specific tags
)
public class MyRunnerTest {     //Use adding test in the last is important while running the project from command line as maven will not identify runner we need to append test


}
