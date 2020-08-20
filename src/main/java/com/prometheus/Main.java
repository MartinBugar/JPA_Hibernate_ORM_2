package com.prometheus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("prometheus.com log1");
        logger.error("bez linku log2");
        logger.error("prometheus.com log3");
        logger.error("prometheus.com log4");
    }
}
