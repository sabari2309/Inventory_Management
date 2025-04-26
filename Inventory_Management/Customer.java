import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private String username;
    private String password;
    private String name;
    private String mobile_number;
    private List<Order> orders;

    public Customer(String username, String password, String name, String mobile_number) {
        this.username = username;
        this.password = 'a'+password+'a';
        this.name = name;
        this.mobile_number = mobile_number;
        orders=new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password.substring(1,password.length()-1);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed at "+this.getName());
        System.out.println("Order Summary");
        List<Inventory> product=order.getProducts();
        for(Inventory in:product){
            System.out.println(in.getBrand()+" "+in.getPrice()+" "+in.getModel());
        }
        System.out.println("Total Price:"+order.getTotalPrice());
        System.out.println("Invoice Number:"+order.getInvoiceNumber());
    }

    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }



}
