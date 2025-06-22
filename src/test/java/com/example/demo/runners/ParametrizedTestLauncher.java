package com.example.demo.runners;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class ParametrizedTestLauncher {
    public static void main(String[] args) {
        LauncherDiscoveryRequestBuilder requestBuilder = LauncherDiscoveryRequestBuilder.request();

        if (args.length == 0) {
            requestBuilder.selectors(selectPackage("com.example.demo.tests"));
        } else {
            for (String className : args) {
                try {
                    Class<?> testClass = Class.forName("com.example.demo.tests." + className);
                    requestBuilder.selectors(selectClass(testClass));
                } catch (ClassNotFoundException e) {
                    System.err.println("Test class not found: " + className);
                }
            }
        }

        LauncherDiscoveryRequest request = requestBuilder.build();
        Launcher launcher = LauncherFactory.create();
        launcher.execute(request, new CustomTestListener());
    }
}
