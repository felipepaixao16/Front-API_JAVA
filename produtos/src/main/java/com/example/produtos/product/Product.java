package com.example.produtos.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "products")
@Getter // essa anotação gera todos os métodos de Geters da minha class Product
@NoArgsConstructor // faz o Lombok declarar um Constructor que não recebe nenhum argumento
@AllArgsConstructor // faz o Lombok declarar um Constructor que recebe todos os argumentos
@EqualsAndHashCode(of = "id") // indica que o "id" é uma representação única do Product
public class Product {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String image;
        private Integer price;

        public Product(ProductResquestDTO data){
                this.image = data.image();
                this.price = data.price();
                this.title = data.title();
        }
}
