package com.techelevator.view;

import com.techelevator.customExceptions.InsufficientBalanceException;
import com.techelevator.customExceptions.InvalidFormOfPayment;
import com.techelevator.customExceptions.OutOfStockException;

public class VendingMachine {

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private final Menu menu;
    private final Inventory inventory;
    private final MoneyHandler moneyHandler;
    Log log = new Log();


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

    public void displayPurchaseMenu() {
        while(true){
            System.out.println(System.lineSeparator() + "Current Money Provided: $" + MoneyHandler.doubleToString(moneyHandler.getBalance()));
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            switch(choice){
                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    // feed money into the vending machine
                    int depositAmount = menu.feedMoney();
                    try {
                        moneyHandler.addToBalance(depositAmount);
                    } catch (InvalidFormOfPayment e) {
                        System.out.println(e.getMessage());
                    }
                    log.logDeposit(depositAmount, moneyHandler.getBalance());
                    break;
                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                    //select a product from list of items
                    inventory.displayItems();
                    Item selectedProduct = menu.getProductSelectionFromUserInput(inventory);
                    try {
                        double availableBalance = moneyHandler.getBalance();
                        selectedProduct.dispense(availableBalance);
                        moneyHandler.subtractFromBalance(selectedProduct.getPrice());
                        log.logPurchase(selectedProduct.getLocationSlot(), selectedProduct.getName(), selectedProduct.getPrice(), moneyHandler.getBalance());
                    } catch (NullPointerException e) {
                        System.out.println(System.lineSeparator() + "*** Invalid item location ID ***");
                    } catch (InsufficientBalanceException | OutOfStockException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                    //finishes interaction with vending machine
                    try {
                        moneyHandler.makeChange();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("A valid choice was not selected.");

            }
        }
    }
}
