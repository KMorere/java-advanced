package fr.fms;

public class Menu {
	private Product[][] menu = {
			{new Product("None", 0), new Product("Salad", 5), new Product("Soup", 5), new Product("Quiche", 5)},
			{new Product("None", 0), new Product("Chicken", 15), new Product("Beef", 15), new Product("Fish", 15)},
			{new Product("None", 0), new Product("Rice", 5), new Product("Pasta", 5), new Product("Fries", 5), new Product("Vegetables", 5)},
			{new Product("None", 0), new Product("Water", 0), new Product("Soda", 2), new Product("Wine", 5)},
			{new Product("None", 0), new Product("Pie", 5), new Product("Chocolate Mousse", 5), new Product("Tiramisu", 5)}
	};
	
	public Product[][] getMenu() {
		return this.menu;
	}
	
	public Product[] getRow(int index) {
		return this.menu[index];
	}
	
	public void displayMenu() {
		for (Product[] rows : this.menu) {
			for(int i = 0; i < rows.length; i++) {
				System.out.printf("[" + i + " - " + rows[i].getName() + "]");
			}
			System.out.println();
		}
	}
	
	public void displayRow(int index) {
		for(int i = 0; i < this.menu[index].length; i++) {
			System.out.print("[" + i + " - " + this.menu[index][i].getName() + "]");
		}
		System.out.println();
	}
	
	public int getBiggestChar() {
		int size = 0;
		for (Product[] rows : this.getMenu())
			for (Product prod : rows) {
				if (prod.getName().length() > size)
					size = prod.getName().length();
			}
		return size;
	}
}
