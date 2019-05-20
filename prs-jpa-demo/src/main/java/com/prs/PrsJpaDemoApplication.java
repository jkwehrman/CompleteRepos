package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.prs.business.Product;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.db.ProductDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.db.PurchaseRequestDB;
import com.prs.db.PurchaseRequestLineItemDB;
import com.prs.util.Console;

@SpringBootApplication 
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello");


		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			displayMenu();
			choice = Console.getRequiredString("Option?:");
			if (choice.equalsIgnoreCase("user")) {
				// list users
				List<User> users = UserDB.getAll();

				if (users!=null) {
					for (User u:  users) {
						System.out.println(u);
					}
				}
				else  {
					System.out.println("users null");
				}

			}
			else if (choice.equalsIgnoreCase("vendor")) {
				// list vendors
				List<Vendor> vendors = VendorDB.getAll();

				if (vendors!=null) {
					for (Vendor v:  vendors) {
						System.out.println(v);
					}
				}
				else  {
					System.out.println("vendors null");
				}

			}
			else if (choice.equalsIgnoreCase("product")) {
				// list products
				List<Product> products = ProductDB.getAll();

				if (products!=null) {
					for (Product p:  products) {
						System.out.println(p);
					}
				}
				else  {
					System.out.println("products null");
				}

			}

			else if (choice.equalsIgnoreCase("pr")) {
				// list purchaseRequest
				List<PurchaseRequest> purchaseRequest = PurchaseRequestDB.getAll();

				if (purchaseRequest !=null) {
					for (PurchaseRequest a:  purchaseRequest) {
						System.out.println(a);
					}
				}
				else  {
					System.out.println("purchase requests null");
				}
			}	


			else if (choice.equalsIgnoreCase("prli")) {
				// list purchaseRequestLineItem 
				List<PurchaseRequestLineItem> purchaseRequestLineItem = PurchaseRequestLineItemDB.getAll();

				if (purchaseRequestLineItem !=null) {
					for (PurchaseRequestLineItem b: purchaseRequestLineItem) {
						System.out.println(b);
					}
				}
				else  {
					System.out.println("purchase requests null");
				}
			}
			
			
//			String uname = Console.getRequiredString("Username: ");
//			String pwd = Console.getRequiredString("Pwd:  ");
//			String fname = Console.getRequiredString("First Name:  ");
//			String lname = Console.getRequiredString("Last Name:  ");
//			String phone = Console.getRequiredString("Phone:  ");
//			String email = Console.getRequiredString("Email:  ");
//
//			User usr = new User(uname,pwd,fname,lname,phone,email,true,true);
//			if (UserDB.add(usr)) {
//				System.out.println("User added");
//			}
//			else {
//				System.out.println("Error adding user");
//			}


			System.out.println("Bye");
		}
	}

	private static void displayMenu() {
		System.out.println("Options:");
		System.out.println("User:\t\tList Users");
		System.out.println("Vendor:\t\tList Vendors");
		System.out.println("Product:\tList Products");
		System.out.println("PR:\t\tList Purchase Requests");
		System.out.println("PRLI:\tList Purchase Request Line Item");
		System.out.println("Exit:\t\tExit App");
	}
}

/*

package com.prs;  

import java.util.List;

import javax.persistence.EntityTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.db.ProductDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.util.Console;

import business.Stuffy;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello");


		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			displayMenu();
			choice = Console.getRequiredString("Option?:");
			if (choice.equalsIgnoreCase("user")) {
				// list users
				List<User> users = UserDB.getAll();

				if (users!=null) {
					for (User u:  users) {
						System.out.println(u);


					}
				}
				else  {
					System.out.println("users null");
				}

			}
			else if (choice.equalsIgnoreCase("add")) {
				addUser();


//
//			}
//			else if (choice.equalsIgnoreCase("delete")) {
//				deleteUser();
//

//
//			}
//			else if (choice.equalsIgnoreCase("vendor")) {
//				// list vendors
//				List<Vendor> vendors = VendorDB.getAll();
//
//				if (vendors!=null) {
//					for (Vendor v:  vendors) {
//						System.out.println(v);
//					}
//				}
//				else  {
//					System.out.println("vendors null");
//				}
//
//			}
//			else if (choice.equalsIgnoreCase("product")) {
//				// list products
//				List<Product> products = ProductDB.getAll();
//
//				if (products!=null) {
//					for (Product p:  products) {
//						System.out.println(p);
//					}
//				}
//				else  {
//					System.out.println("products null");
//				}
//
//			}
//		}
//
//		System.out.println("Bye");
//	}
//
//	private static void displayMenu() {
//		System.out.println("Options:");
//		System.out.println("User:\t\tList Users");
//		System.out.println("Add: \t\t Add Users");
//		System.out.println("Delete: \t\t Delete Users");
//		System.out.println("Vendor:\t\tList Vendors");
//		System.out.println("Product:\tList Products");
//		System.out.println("Exit:\t\tExit App");
//	}

	private static void addUser() {
		String uname = Console.getRequiredString("Username: ");
		String pwd = Console.getRequiredString("Password:  ");
		String fname = Console.getRequiredString("First Name:  ");
		String lname = Console.getRequiredString("Last Name:  ");
		String phone = Console.getRequiredString("Phone:  ");
		String email = Console.getRequiredString("Email:  ");

		User usr = new User(uname,pwd,fname,lname,phone,email,true,true);
		if (UserDB.add(usr)) {
			System.out.println("User added");
		}
		else {
			System.out.println("Error adding user");}
		}
		//look here - there is trouble

	private static void deleteStuffy() {
		int id = Console.getInt("Enter stuffy id to delete:  ");
		System.out.println("!!!  Delete Product !!!");

		Stuffy s = stuffyDB.get(id);

		if (s == null) {
			System.out.println("invalid code.");
		} else {
			if (stuffyDB.delete(s)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting product.");
			}
		}






		private static void deleteUser() {
			int id = Console.getInt("Enter user id to delete:  ");
			System.out.println("!!! You are about to delete a User !!!");
			User u; 
			u = UserDB.getId();

					if (u == null) {
					System.out.println("invalid code.");
				} else {
					if (com.prs.db.UserDB.delete(u)) {
						System.out.println("Delete success");
					} else {
						System.out.println("Error deleting product.");
					}
				}		

			int user = Console.getInt("Enter user id to delete:  ");
			User usr = new User ();
			usr.setId(user);


			if (UserDB.delete(usr)) {
				System.out.println("User deleted");
			}
			else {
				System.out.println("Error deleting user");
			}


 */
