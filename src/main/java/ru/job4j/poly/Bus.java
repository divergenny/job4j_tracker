package ru.job4j.poly;

public class Bus implements Transport {
    private double price = 129;

    @Override
    public void drive() {
        System.out.println("The bus goes to its destination...");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("For today, the bus served" + passengers + "passengers");
    }

    @Override
    public double fillUpTank(int quantity) {
        return price * quantity;
    }
}
