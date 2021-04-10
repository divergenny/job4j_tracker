package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        for (int itr = index; itr < products.length; itr++) {
            if (products[index] == null && index + 1 != products.length) {
                products[index] = products[index + 1];
                products[index + 1] = null;
            } else if (index + 1 == products.length) {
                products[index] = null;
            }
        }
        return products;
    }
}
