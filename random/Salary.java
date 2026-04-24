package random;
import java.util.Scanner;

public class Salary {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int iprodId;
        String strProdName;
        String strProdDesc;
        double dQty;
        double dPrice;
        double dDiscount;

        System.out.println("Please input the following: ");
        System.out.print("ProductID: ");
        iprodId = inputInt();
        input.nextLine();
        System.out.print("Name: ");
        strProdName = inputString();
        System.out.print("Desciption: ");
        strProdDesc = inputString();
        System.out.print("Quantity: ");
        dQty = inputDouble();
        System.out.print("Price: ");
        dPrice = inputDouble();
        System.out.print("Discount: ");
        dDiscount = inputDouble();
        productDetails(iprodId, strProdName, dPrice, dQty, dDiscount);

    }

    public static String inputString() {
        return input.nextLine();
    }

    public static int inputInt() {
        return input.nextInt();
    }

    public static double inputDouble() {
        return input.nextDouble();

    }

    public static double getSubtotal(double dPrice, double dQty, double dDiscount) {
        return (dPrice * dQty) - dDiscount;
    }

    public static void productDetails(int iprodId, String strProdName, double dPrice, double dQty,
            double dDiscount) {

        System.out.printf(" %d %s \n Price at %.2f for %.2f pieces \n Discounted at %.2f \n Subtotal %.2f ", iprodId,
                strProdName, dPrice, dQty, dDiscount, getSubtotal(dPrice, dQty, dDiscount));

    }
}
