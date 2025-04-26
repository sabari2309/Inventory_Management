import java.util.*;

public class Order {
    private static int invoice=30000;
    private Customer customer;
    private String invoiceNumber;
    private int totalPrice;
    private List<Inventory> products;
    public Order(Customer customer) {
        this.customer = customer;
        this.invoiceNumber = String.valueOf(invoice+1);
        products=new ArrayList<>();
    }

    public static int getInvoice() {
        return invoice;
    }

    public static void setInvoice(int invoice) {
        Order.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Inventory> getProducts() {
        return products;
    }

    public void setProducts(List<Inventory> products) {
        this.products = products;
    }

    public void addproductAndprice(Map<Inventory, Integer> details) {
        for(Map.Entry<Inventory,Integer>map:details.entrySet()){
            products.add(map.getKey());
            totalPrice+=map.getValue()*map.getKey().getPrice();

        }
    }

    public String toString() {
        return "Order{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                '}';
    }
}
