package com.ns.iskingincheckandroid.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.ns.iskingincheckandroid.cucumber.steps"],
    tags = "@e2e"
)
@SuppressWarnings("unused")
class CucumberTestCase : CucumberAndroidJUnitRunner()