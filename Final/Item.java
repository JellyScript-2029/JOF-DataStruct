public class Item {
    String brand, prodName, size, color;
    double price;

    public Item(String brand, String prodName, String size, String color, double price) {
        this.brand = brand;
        this.prodName = prodName;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-22s %-8s %-10s %10.2f", brand, prodName, size, color, price);
    }

    public String toDetailString() {
        return "Brand: " + brand + "\nProduct: " + prodName + "\nSize: " + size + "\nColor: " + color + "\nPrice: $" + price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}