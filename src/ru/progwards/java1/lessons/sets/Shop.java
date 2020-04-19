package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.List;

public class Shop {
        private List<Product> products = new ArrayList<>();
        public Shop(List<Product> products){
            this.products.addAll(products);
        }
        public List<Product> getProducts(){
            return this.products;
        }

}
