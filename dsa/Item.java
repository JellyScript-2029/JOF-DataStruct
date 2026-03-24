package dsa;
public class Item {
    String brand;
    String prodName;
    String size;
    String color;
    double price;

    public Item(String brand, String prodName, String size, String color, double price){
        this.brand = brand;
        this.prodName = prodName ;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String toString(){
        return  String.format("%-15s %-23s %-8s %-12s $%.2f", brand, prodName, size, color, price);
    }
}
