package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Pp{
    public static void main(String[] args) {
        List<Shop> shops = new ArrayList<>();
        List<Product> prod1 = new ArrayList(List.of("art-2","art-6","art-8","art-10"));
        List<Product> prod2 = new ArrayList(List.of("art-3","art-8","art-9","art-10"));
        List<Product> prod3 = new ArrayList(List.of("art-2","art-5","art-10"));
        List<Product> prodControl = new ArrayList(List.of("art-1","art-2","art-3",
                "art-4","art-5","art-6","art-7","art-8","art-9","art-10"));
        Shop magasin1 = new Shop(prod1);
        Shop magasin2 = new Shop(prod2);
        Shop magasin3 = new Shop(prod3);
        shops.add(magasin1);
        shops.add(magasin2);
        shops.add(magasin3);
        ProductAnalytics analit = new ProductAnalytics(prodControl,shops);
        var a = analit.existInAll();
        var b = analit.notExistInShops();
        var d = analit.existOnlyInOne();
        //System.out.println(a);
        //System.out.println(b);
        System.out.println(d);
    }
}
public class ProductAnalytics {
        private List<Shop> shops = new ArrayList<>();
        private List<Product> products = new ArrayList<>();
        public ProductAnalytics(List<Product> products, List<Shop> shops){
            this.shops.addAll(shops);
            this.products.addAll(products);
        }
        public Set<Product> existInAll(){
            Set<Product> goods = new HashSet<>(this.products);
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
            Set<Product> tmp = new HashSet<>(this.products);
            tmp.removeAll(goods);
            return tmp;
        }
        public Set<Product> existOnlyInOne(){
            Set<Product> goods = new HashSet<>();
            Set<Product> del = new HashSet<>();
            for(int i = 0; i < shops.get(i).getProducts().size(); i++) {
                Product a = shops.get(i).getProducts().get(i);
                for(int j = 1; j< shops.get(j).getProducts().size(); j++){
                    Product b = shops.get(j).getProducts().get(j);
                    if(a.equals(b))
                        del.add(a);
               }
            }
                //goods.addAll(shops.get(j).getProducts());

            return del;
        }
}


