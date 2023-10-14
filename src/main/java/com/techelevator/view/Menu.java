package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.parseInt(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public int feedMoney() {
		System.out.print(System.lineSeparator() + "Please feed in your money >>> ");
		String userInput = in.nextLine();
		int money = 0;

		try {
			money = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator() + "No money has been added to your balance.");
		}

		return money;
	}

	public Item getProductSelectionFromUserInput(Inventory inventory){
		List<String> locationSlots = inventory.getLocationSlots();
		String productSelection;
		String userInput;

		System.out.print(System.lineSeparator() + "Select a product by inputting the item's location ID >>> ");
		userInput = in.nextLine();
		productSelection = userInput.toUpperCase().trim();

		return inventory.getItem(productSelection);
	}
}
