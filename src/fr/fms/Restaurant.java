package fr.fms;

import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Restaurant {
	static Scanner scan = new Scanner(System.in);
	static Menu menuItem = new Menu();
	static Product[][] menu = menuItem.getMenu();
	
	private static Order new_order;
	
	private static String fileName = "order.txt";
	private static File orderFile = new File(fileName);
	
	public static void main(String[] args) {
		System.out.println("Hello, how many orders do you want ?");
		if (!scan.hasNextInt())
			System.out.println("Please select a valid amount.");
		
		int amount = scan.nextInt();
		new_order = new Order(new Product[menu.length]);
		
		for (int i = 1; i <= amount; i++) { // Do as many orders as requested beforehand.
			System.out.println("Starting order " + (i));
			startOrder(i);
		}
		
		System.out.println("Enjoy your meal !");
		printOrder(query);
		
		if (Files.exists(Paths.get(fileName)))
			readFile(orderFile);
		
		scan.close();
	}
	
	/**
	 * Initialize an order.
	 * @param index Current order number.
	 */
	private static void startOrder(int index) {
		Product[] order = new_order.getOrder();
		
		for(int i = 0; i < menu.length; i++) {
			order[i] = selectOrder(i);
			new_order.setPrice(order[i].getPrice());
		}
		new_order.setOrder(order);

		System.out.print("[");
		for(int i = 0; i < order.length; i++) {
			System.out.print(order[i].getName());
			if (i < order.length-1)
				System.out.print(", ");
		}
		System.out.print("]");
		System.out.println("\n");
		
		new_order.setOrder(order);
		
		setQuery(new_order, index);
	}
	
	/**
	 * Selection of an element from the menu array.
	 * @param index Index parameter given from startOrder() for the selected order.
	 * @return Returns the element from the menu array.
	 */
	private static Product selectOrder(int index) {
		for(int i = 0; i < menu[index].length; i++) {
			System.out.printf("[" + i + " - " + menu[index][i].getProduct() + "]");
		}
		System.out.println();
		
		System.out.println("Select " + menuItem.getMenuType(index).toLowerCase() + " :");
		if (!scan.hasNextInt())
			return menu[index][0]; // Return None in the menu if the input is not valid.
		
		int input = scan.nextInt();
		
		if (input < 0 && input >= menu[index].length)
			return menu[index][0]; // Return None in the menu if the input is not valid.
		
		return menu[index][input];
	}
	
	/**
	 * Set the summary of the full order.
	 */
	private static String query = "";
	private static void setQuery(Order order, int index) {
		if (index == 1) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			query += LocalDateTime.now().format(format)+"\n";
		}
		query += ("=====[Order N°"+(index)+"]=====\n");
		int i = 0;
		for (Product item : order.getOrder()) {
			query += String.format(
					menuItem.displayTypef(15)+" | ", menuItem.getMenuType(i));
			query += String.format(
					item.getProductf(menuItem.getBiggestChar()), 
					item.getName(), item.getPrice())+"\n";
			i++;
		}
	}
	
	/**
	 * Initialize the print of a full order.
	 * @param query Text order from setQuery.
	 */
	private static void printOrder(String query) {
		if (!Files.exists(Paths.get(fileName)))
			orderFile = new File(fileName);

		query += "\nTotal : "+new_order.getPrice()+" €";
		
		writeFile(query);
	}
	
	/**
	 * Read the last order.
	 * @param file
	 */
	private static void readFile(File file) {
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a new order file.
	 * @param text
	 */
	private static void writeFile(String text) {
		try {
			// Set FileWriter append to 'true' if you don't want to overwrite the .txt
			FileWriter writer = new FileWriter(fileName, false);
			writer.write(System.lineSeparator() + text);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
