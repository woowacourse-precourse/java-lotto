package lotto.model;

public class Player {
    private int purchaseAmount;
    private int ticketNumber;

    public Player(String amountString) {
        validate(amountString);
        this.purchaseAmount = Integer.parseInt(amountString);
        ticketNumber = purchaseAmount / 1000;
    }

    public void validate(String purchaseAmountString) {
        int purchaseAmount = Integer.parseInt(purchaseAmountString);
        if (purchaseAmount < 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount() {

        return purchaseAmount;
    }

    public int getTicketNumber() {

        return ticketNumber;
    }
}
