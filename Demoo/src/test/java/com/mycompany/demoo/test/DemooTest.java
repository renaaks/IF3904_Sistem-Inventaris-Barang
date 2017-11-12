/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoo.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author Novelty Octaviani
 */
@RunWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(plugin = { "pretty", "html:target/cucumber","json:target/cucumber.json" })
public class DemooTest {
    
}
