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
        return  "Brand: " + brand + "\nProduct: " + prodName + "\nSize: " + size + "\nColor: " + color + "\nPrice: $" + price;
    }
}
