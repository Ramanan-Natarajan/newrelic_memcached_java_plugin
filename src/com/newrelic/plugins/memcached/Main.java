package com.newrelic.plugins.memcached;

import com.newrelic.metrics.publish.Runner;
import com.newrelic.metrics.publish.configuration.ConfigurationException;

/**
 *  This is the main calling class for a New Relic Agent
 *  This class sets up the necessary agents from the provided configuration
 *  and runs these indefinitely.
 *
 *  @author Adam Larson  alarson@newrelic.com
 *
 */
public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.add(new MemcachedAgentFactory());

        try {
            runner.setupAndRun();											// Never returns
        } catch (ConfigurationException e) {
            e.printStackTrace();
            System.err.println("Error configuring New Relic Agent");
            System.exit(1);
        }

    }
}
