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
