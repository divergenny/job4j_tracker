package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        for (int itr = index; itr < products.length - 1; itr++) {
            products[itr] = products[itr + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
