import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Management system = new Management();
        while (true) {
            System.out.println("WELCOME TO Z-KART");
            System.out.println("1.Login and Place Order");
            System.out.println("2.Create a Account");
            System.out.println("3.Admin Panel");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Login Page");
                    System.out.println("Enter Your UserName/Email");
                    String username = sc.next();
                    if(system.validateuser(username)){
                        System.out.println("Invalid username");
                        break;
                    }
                    System.out.println("Enter your Password");
                    String password = sc.next();
                    Customer customer = system.validate(username, password);
                    if (customer != null) {
                        System.out.println("Successfully Logged In as " + customer.getName());
                        boolean bol=true;
                        while(bol) {
                            System.out.println("1.Purchase");
                            System.out.println("2.View Orders");
                            System.out.println("3.Logout");
                            System.out.println("Enter your choice");
                            int n = sc.nextInt();
                            switch (n) {
                                case 1:
                                    system.displayInventories();
                                    boolean bool = true;
                                    Map<Integer, Integer> cartId = new ConcurrentHashMap<>();
                                    while (bool) {
                                        System.out.println("Choose the product id that you want to purchase");
                                        int id = sc.nextInt();
                                        Inventory product = system.checkAndgetProduct(id);
                                        if (product != null) {
                                            System.out.println("Dispalying product Details");
                                            System.out.println(product.getCategory() + " " + product.getModel() + " " + product.getStock() + " " + product.getPrice());
                                            System.out.println("Enter How many numbers of product are required");
                                            int numbers = sc.nextInt();
                                            System.out.println("Do you want to add more product to cart.Type 'OK' to add");
                                            System.out.println("Type 'Next' to stop and place order");
                                            String option = sc.next();
                                            if (option.equalsIgnoreCase("OK")) {
                                                System.out.println("Adding the product to the Cart");
                                                Thread.sleep(2000);
                                                cartId.put(id, numbers);
                                            } else if (option.equalsIgnoreCase("Next")) {
                                                cartId.put(id, numbers);
                                                System.out.println("You are moved to product page.Checking the product Availability");
                                                Thread.sleep(2000);
                                                system.checkAvailability(cartId, customer);
                                                bool = false;
                                            }

                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("View all your orders");
                                    system.displayAllorders(customer);
                                    break;
                                case 3:
                                    System.out.println("Logged out successfully");
                                    bol=false;
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        }
                      break;
                    }

                case 2:
                    System.out.println("Welcome to SignUp Page");
                    System.out.println("Enter a Username/Email");
                    String newuser = sc.next();
                    System.out.println("Enter a Strong password of minimum 4 characters");
                    String newpass = sc.next();
                    System.out.println("Enter your Name");
                    String name = sc.next();
                    System.out.println("Enter your mobile number");
                    String number = sc.next();
                    if(number.length()!=10){
                        System.out.println("Enter valid mobile number");
                        break;
                    }
                    System.out.println("Creating an Account...");
                    Thread.sleep(2000);
                    system.createUserAccount(newuser, newpass, name, number);
                    break;
                case 3:
                    System.out.println("Admin Panel.Only Admin can Login");
                    System.out.println("Enter Admin Username");
                    String adminUser = sc.next();
                    if(system.validateAdminname(adminUser)){
                        System.out.println("Invalid Admin Nname");
                        break;
                    }
                    System.out.println("Enter Admin Password");
                    String adminpass = sc.next();
                    Admin admin = system.validateAdmin(adminUser, adminpass);
                    if (admin == null) {
                        System.out.println("Invalid Credentials");
                        break;
                    }
                    System.out.println("Checking the low stock available products");
                    system.displayLowInventories();
                    System.out.println("Here is the updated stocks");
                    system.displayInventories();
                    break;
                case 4:
                    System.out.println("Exiting the Application");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

}