## Technical Presentation for Vendo-matic 800

### Demo

Ryan will share screen.

### Tests

    > (1) Inventory Tests
    > (2) Item Tests
    > (3) MoneyHandler Tests
    > (4) Log Tests

### VendingMachineCLI

Talk about how we broke down the project into classes so that the Vending Machine Client could stay clean and simple.

### Item

Talk about how we chose to make Item abstract with an abstract method displaySound() so that each subclass can display
different sounds depending on whether it's Chips, Candy, Drink, or Gum.
Mention custom exception
Brandish present dispense() and getDisplayString()

### Inventory

Ryan will present csvFileToMap()

### MoneyHandler

Ryan can briefly mention add and subtract from balance.
InsufficientBalanceException and InvalidFormOfPayment custom exceptions.
Brandish made the doubleToString method to ensure correct display of money.
Ryan will present makeChange()

## Menu

Aubrey will present feedMoney() as it was a pair-programmed method.
Brandish will present getProductSelectionFromUserInput()

## Log

All Aubrey

### VendingMachine

The main method of VendingMachine is the displayPurchaseMenu