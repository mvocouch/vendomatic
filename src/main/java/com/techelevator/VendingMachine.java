package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachine {

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;
    private Inventory inventory;
    private MoneyHandler moneyHandler;


    public VendingMachine() {
        this.moneyHandler = new MoneyHandler();
        this.inventory = new Inventory();
        this.menu = new Menu(System.in, System.out);
    }

    public Menu getMenu() {
        return menu;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public void displayPurchaseMenu() {
        while(true){
            System.out.print(System.lineSeparator() + "Current Money Provided: $" + moneyHandler.doubleToString(moneyHandler.getBalance()) + System.lineSeparator());
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            switch(choice){
                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    // feed money into the vending machine
                    moneyHandler.addToBalance(menu.feedMoney());
                    break;
                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                    //select a product from list of items
                    break;
                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                    //finishes interaction with vending machine

                    return;
                default:
                    throw new IllegalArgumentException("A valid choice was not selected.");

            }
        }
    }
}
