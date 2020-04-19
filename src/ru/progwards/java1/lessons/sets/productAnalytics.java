package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class productAnalytics {
    class Product{
        private String code = "";
        public Product(String code){
            this.code = code;
        }
        public String getCode(){
            return this.code;
        }
    }
    class Shop{
        private List<Product> products = new ArrayList<>();
        public Shop(List<Product> products){
            this.products.addAll(products);
        }
        public List<Product> getProducts(){
            return this.products;
        }
    }
    class ProductAnalytics{
        private List<Shop> shops = new ArrayList<>();
        private List<Product> products = new ArrayList<>();
        public ProductAnalytics(List<Product> products, List<Shop> shops){
            this.shops.addAll(shops);
            this.products.addAll(products);
        }
        public Set<Product> existInAll(){
            Set<Product> goods = new HashSet<>();
            for(int i = 0; i < shops.size(); i++){
                goods.retainAll(shops.get(i).getProducts());
            }
            return goods;
        }
        public Set<Product> existAtListInOne(){
            Set<Product> goods = new HashSet<>();
            for(int i = 0; i < shops.size(); i++){
                goods.addAll(shops.get(i).getProducts());
            }
            return goods;
        }
        public Set<Product> notExistInShops(){
            Set<Product> goods = new HashSet<>();
            for(int i = 0; i < shops.size(); i++) {
                goods.addAll(shops.get(i).getProducts());
            }
            Set<Product> tmp = new HashSet<>();
            for(int i = 0; i < shops.size(); i++) {
                tmp.retainAll(shops.get(i).getProducts());
            }
            goods.removeAll(tmp);
            return goods;
        }
        public Set<Product> existOnlyInOne(){
            Set<Product> goods = new HashSet<>();
            for(int i = 0; i < shops.size(); i++){
                goods.removeAll(shops.get(i).getProducts());
            }
            return goods;
        }
    }

}
