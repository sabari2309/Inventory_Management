🛒 Inventory Management System
📋 About the Project
This is a Java-based console application designed to simulate a simple inventory and order management system for an e-commerce platform (Z-Kart 🚀).

The system allows:

🧍‍♂️ Customers to create accounts, browse products, place orders.

🛠 Admins to monitor and update inventory.

This project demonstrates core Java concepts like OOPS, File Handling, and a simple simulation of real-world workflows.

✨ Features
🧍‍♂️ Customer Functionalities:
Create a new account and log in securely.

Browse available products from inventory.

Add products to cart and place multiple orders.

View past orders with generated invoices.

🛠 Admin Functionalities:
Secure login for admin.

View low-stock products and update stock levels.

Browse the full inventory list.

📦 Inventory Management:
Each product has category, brand, model, price, stock.

Automatic stock updates after purchases.

Unique product IDs and invoice generation for orders.

🛠 Built With
Java – Core Java, OOPS, Collections, File Handling

Text file (Customer.txt) – To manage customer data

Console UI – Simple CLI for interaction

📂 Project Structure
plaintext
Copy
Edit
├── Admin.java         // Admin class (credentials & controls)
├── Customer.java      // Customer class (account and orders)
├── Inventory.java     // Inventory handling
├── Management.java    // Central controller for the app
├── Order.java         // Order details and invoice generation
├── Main.java          // Main application runner
├── Customer.txt       // Preloaded customer data
🚀 How to Run
Clone this repository:

bash
Copy
Edit
git clone https://github.com/your-username/Inventory-Management-System.git
Open the project in your IDE (IntelliJ, Eclipse, VSCode).

Run Main.java.

Interact via console menu to:

Login as Admin or Customer

View inventory

Place orders

Manage stock!

📌 Future Improvements
🔐 Add password encryption for better security.

🗂 Shift to persistent storage (files/databases).

🎨 Build a GUI version using Swing/JavaFX.

🛒 Cart update/removal functionality.

📈 Enhance admin dashboard with analytics.

🙌 Acknowledgements
This project was built for learning purposes — to practice Java application design, real-world problem solving, and software architecture.

“Every great system starts with one line of code — and a lot of coffee ☕.”

🚀 Happy Coding!
