package com.appsdeveloperblog.estore.ProductsService.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsRestController {

    private final Environment env;

    public ProductsRestController(Environment env) {
        this.env = env;
    }

    @GetMapping("/hello")
    public String hello() {
        return "HELLO " + env.getProperty("local.server.port");
    }

    @GetMapping("/port1")
    public String port1() {
        // local.server.port => local 에서 app 실행 시 사용 된 port
        // server.port => application.properties 에 선언 된 port(현재는 0)
        return "HELLO " + env.getProperty("local.server.port");
    }

    @GetMapping("/port2")
    public String port2() {
        return "HELLO " + env.getProperty("server.port");
    }
}
