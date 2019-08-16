package com.simulation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 测试
 *
 * @author hedongzhou
 * @since 2019/08/17
 */
@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            LOG.info("test {}", i);

            if (random.nextInt(10) > 7) {
                LOG.error("error {}", i);
                return "NO";
            }

            try {
                Thread.sleep(100 * (random.nextInt(10) + 1));
            } catch (Exception ignored) {
            }
        }

        return "OK";
    }

}
