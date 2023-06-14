package com.example.produtos.controller;

import com.example.produtos.product.ProductRepository;
import com.example.produtos.product.Product;
import com.example.produtos.product.ProductResponseDTO;
import com.example.produtos.product.ProductResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indicando para o Spring que essa class é um Controller
@RequestMapping("product") // mapeia o request
public class ProductController {

    @Autowired // indica o Spring para injetar a dependência da class ProductController que ele está instanciando
    private ProductRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveProduct(@RequestBody ProductResquestDTO data) {
        Product productData = new Product(data);
        repository.save(productData);
        return;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    // criando o get
    @GetMapping
    public List<ProductResponseDTO> getAll() {

        List<ProductResponseDTO> produtosList = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return produtosList;
    }
}
