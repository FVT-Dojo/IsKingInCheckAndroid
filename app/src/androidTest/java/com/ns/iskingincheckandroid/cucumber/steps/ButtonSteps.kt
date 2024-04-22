package com.ns.iskingincheckandroid.cucumber.steps

import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

class ButtonSteps {

    @When("I navigate to the home page")
    fun iNavigateToTheHomePage() {
    }

    @Then("I should see a button with the label {string}")
    fun iShouldSeeAButtonWithTheLabel(label: String) {
        onView(withText(label)).check(matches(isDisplayed()))
    }
}