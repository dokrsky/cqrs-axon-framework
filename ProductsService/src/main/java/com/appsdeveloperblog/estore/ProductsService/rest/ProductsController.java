package com.appsdeveloperblog.estore.ProductsService.rest;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Environment env;
    private final CommandGateway commandGateway;

    public ProductsController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;

        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }

        return returnValue;
    }

}
