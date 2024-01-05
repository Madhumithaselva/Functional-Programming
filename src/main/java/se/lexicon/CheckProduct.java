package se.lexicon;
import se.lexicon.interfaces.Action;
import se.lexicon.interfaces.Condition;

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class CheckProduct {
    public static void applyActionOnProducts(List<Product> products, Condition condition, Action action){
        for (Product p:products){
            if (condition.test(p)){
                action.execute(p);
            }
        }
    }
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("A",50,10));
        productList.add(new Product("B",108,2));
        productList.add(new Product("C",145,200));
        productList.add(new Product("D",150,0));
        productList.add(new Product("ABC",200,450));
        productList.add(new Product("Laptop",500,6));
        productList.add(new Product("xyz",110,65));

        //Print out all Products that have stock value of 0.
        applyActionOnProducts(productList,p -> p.getStock()==0, p->System.out.println("Product with stock 0 : " + p.getProductName()));

        //Print out the productName of all the Products that starts with B
        applyActionOnProducts(productList,p -> p.getProductName().startsWith("B"),p -> System.out.println("Product starting with B: "+p.getProductName()));

        //Print out all Products that have price above 100 AND lower than 150
        applyActionOnProducts(productList,p -> p.getPrice()>100 && p.getPrice()<150,p -> System.out.println("Products above 100 and lower than 150 are : "+p.getProductName()));

        //Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        applyActionOnProducts(productList,p -> p.getStock()<10 && p.getStock() >0,p -> {
            double newPrice = p.getPrice()*1.5;
            p.setPrice(newPrice);
            System.out.println("Increased price for products: "+ p.getProductName()+" Price:"+p.getPrice()+" Stock: "+p.getPrice());
        });
    }
}