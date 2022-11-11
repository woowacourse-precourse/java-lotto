package lotto;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String amount) {
        this.amount = convertStringToInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }
}
