package lotto.domain;

public class Buyer {

    private static final int AMOUNT_UNIT = 1000;

    private int purchaseAmount;
    private int ticketAmount;

    private void calculateAmountOfTickets() {
        ticketAmount = purchaseAmount / AMOUNT_UNIT;
    }

    public int changeType(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public void buyTickets(String purchaseAmount) {
        Validation.validateProperLetters(purchaseAmount);
        Validation.validateProperUnitAmount(purchaseAmount);
        this.purchaseAmount = changeType(purchaseAmount);
        calculateAmountOfTickets();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTickets() {
        return ticketAmount;
    }
}