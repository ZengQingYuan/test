package com.simulation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

/**
 * 测试
 *
 * @author hedongzhou
 * @since 2019/08/17
 */

@RestController
public class TestController {


   //private static final Logger LOG = LoggerFactory.getLogger(TestController.class);



    /**
     * 测试
     *
     * @return
     */

    @RequestMapping("/test")
    public String test(Integer id,Integer age) throws JsonProcessingException {

        //String contextPath = request.getServletPath();
        //Map<String, String[]> parameterMap = request.getParameterMap();

        //logger.info("请求路径:"+contextPath);
        //ObjectMapper objectMapper = new ObjectMapper();
       // String json = objectMapper.writeValueAsString(parameterMap);
       // logger.info("请求参数"+json);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            //logger.info("test {}", i);

            if (random.nextInt(10) > 7) {
                //logger.error("error {}", i);
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
