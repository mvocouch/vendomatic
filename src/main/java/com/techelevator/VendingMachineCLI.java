package com.techelevator;

import com.techelevator.view.AsciiPrinter;
import com.techelevator.view.Log;
import com.techelevator.view.VendingMachine;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private final VendingMachine vendingMachine = new VendingMachine();
	private final Log log = new Log();

	public VendingMachineCLI() {
	}

	public void run() {
		AsciiPrinter.printASCII("asciitext.txt");
		while (true) {
			String choice = (String) vendingMachine.getMenu().getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendingMachine.getInventory().displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				vendingMachine.displayPurchaseMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(-1);
			}
		}
	}
			public static void main (String[]args){
				VendingMachineCLI cli = new VendingMachineCLI();
				cli.run();
			}
		}

