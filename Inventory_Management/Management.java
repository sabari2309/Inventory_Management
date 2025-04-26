import java.io.*;
import java.util.*;

public class Management{
    Scanner sc=new Scanner(System.in);
   Map<String,Customer> Users;
   Map<Integer,Inventory> Inventories;
   Map<String,Admin> admin;
   public Management() {
        Users=new HashMap<>();
        Inventories=new HashMap<>();
        admin=new HashMap<>();
        loadData();
    }

    private void loadData() {
       admin.put("admin@zoho.com",new Admin("admin@zoho.com","xyzzy"));
       Users.put("abc@zoho.com",new Customer("abc@zoho.com","saba@123","Rahul","9865475312"));
       Users.put("123@zoho.com",new Customer("123@zoho.com","sow@123","Anitha","8564119904"));
       Users.put("user@zoho.com",new Customer("user@zoho.com","hai@123","Arpan","6380315064"));
       Inventories.put(1,new Inventory("Mobile","Apple","6S",60000,10));
       Inventories.put(2,new Inventory("Mobile","Motorola","G",12000,5));
       Inventories.put(3,new Inventory("Laptop","HP","Elite",5600,20));
       Inventories.put(4,new Inventory("Tablet","Google","ChromeBook",8000,12));
       Inventories.put(5,new Inventory("Lap","Google","MacBook",8000,2));
    }

    public void dispalyUsers() {
       for(Map.Entry<String,Customer> entry:Users.entrySet()){
           System.out.println(entry.getValue());
       }
    }

    public void displayInventories() {
        System.out.println("Product_id  Category  Brand  Model  Price  Stock");
        for(Map.Entry<Integer,Inventory> entry:Inventories.entrySet()){
            Inventory in=entry.getValue();
            System.out.println(in.getProduct_id()+"  "+in.getCategory()+" "+in.getBrand()+"  "+in.getModel()+"  "+in.getPrice()+"  "+in.getStock());
        }
    }

    public Customer validate(String username, String password) {
       if(Users.containsKey(username)){
           if(Users.get(username).getPassword().equals(password)) {
               return Users.get(username);
           }else{
               System.out.println("Wrong password");
               return null;
           }
       }
       System.out.println("Invalid Credentials");
       return null;
    }

    public Inventory checkAndgetProduct(int id) {
       if(Inventories.containsKey(id)){
           return Inventories.get(id);
       }
       System.out.println("Invalid Product id");
       return null;
    }

    public void checkAvailability(Map<Integer, Integer> cartId,Customer customer) {
        for(Map.Entry<Integer,Integer> map:cartId.entrySet()){
            int product_id=map.getKey();
            int numbers=map.getValue();
            Inventory in=Inventories.get(product_id);
            if(in.getStock()<numbers){
                System.out.println("Product "+in.getBrand()+" is out of Stock");
                cartId.remove(product_id);
            }
        }
        if(cartId.isEmpty()){
            System.out.println("Sorry No products available at the moment");
            return;
        }else{
            System.out.println("Placing the order...");
            PlaceOrder(customer,cartId);
        }
    }

    private void PlaceOrder(Customer customer, Map<Integer, Integer> cartId) {
       Map<Inventory,Integer> details=new HashMap<>();
       for(Map.Entry<Integer,Integer>map:cartId.entrySet()){
          details.put(Inventories.get(map.getKey()),map.getValue());
          Inventory update=Inventories.get(map.getKey());
          int newstock=update.getStock()-map.getValue();
          update.setStock(newstock);
       }
       Order order=new Order(customer);
       order.addproductAndprice(details);
       customer.placeOrder(order);
        System.out.println("Product   Numbers ordered");
       for(Map.Entry<Integer,Integer> map:cartId.entrySet()){
           System.out.println(Inventories.get(map.getKey()).getBrand()+" "+map.getValue());
       }
       System.out.println("Thank you for Ordering");
    }

    public void createUserAccount(String newuser, String newpass, String name, String number) {
       if(!Inventories.containsKey(newuser)){
          Users.put(newuser,new Customer(newuser,newpass,name,number));
           System.out.println("Created Successfully");
           System.out.println("Login Again and Place your Orders :)");
           return;
       }else{
           System.out.println("Username/Email already Exists");
           return;
       }
    }

    public Admin validateAdmin(String adminUser, String adminpass) {
       if(admin.containsKey(adminUser) && admin.get(adminUser).getPassword().equals(adminpass)){
           return admin.get(adminUser);
       }
       return null;
    }

    public void displayLowInventories() {
       Set<Integer> set=new HashSet<>();
        System.out.println("Displaying Products less than 10 stocks");
        System.out.println("Product_id  Category  Brand  Model  Price  Stock");
        for(Map.Entry<Integer,Inventory> map:Inventories.entrySet()){
            if(map.getValue().getStock()<10){
                System.out.println(map.getValue());
                set.add(map.getValue().getProduct_id());
            }
        }
        while(set.size()>0) {
            System.out.println("Enter the product id stock to be updated");
            int id = sc.nextInt();
            Inventory inn = Inventories.get(id);
            System.out.println("Enter the numbers to be added");
            int n = sc.nextInt();
            int newstock = inn.getStock() + n;
            inn.setStock(newstock);
            System.out.println("Updated successfully");
            set.remove(id);
        }
    }

    public void displayAllorders(Customer customer) {
       List<Order> orders=customer.getOrders();
       if(orders.size()==0){
           System.out.println("No orders Till Now...");
           return;
       }
        System.out.println("Invoice   Price");
       for(Order o:orders){
           System.out.println(o.getInvoiceNumber()+" "+o.getTotalPrice());
       }
    }

    public boolean validateuser(String username) {
       if(!Users.containsKey(username)){
           return true;
       }
       return false;
    }

    public boolean validateAdminname(String adminUser) {
       if(!admin.containsKey(adminUser)){
           return true;
       }
       return false;
    }
    }
