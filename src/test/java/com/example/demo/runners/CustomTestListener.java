package com.example.demo.runners;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class CustomTestListener implements TestExecutionListener {

    /**
     * Called when a test execution starts.
     * <p>
     * Prints the test display name to standard output to indicate test commencement.
     *
     * @param testIdentifier the descriptor of the starting test
     */
    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        System.out.println("Starting: " + testIdentifier.getDisplayName());
    }

    /**
     * Called when a test execution finishes.
     * <p>
     * Reports both the test name and its final execution status (SUCCESSFUL, FAILED, or ABORTED).
     *
     * @param testIdentifier the descriptor of the finished test
     * @param testExecutionResult the result of the test execution
     */
    @Override
    public void executionFinished(TestIdentifier testIdentifier,
                                  TestExecutionResult testExecutionResult) {
        System.out.println("Finished: " + testIdentifier.getDisplayName() +
                " - " + testExecutionResult.getStatus());
    }
}