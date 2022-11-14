package lotto;

public class Manager {

    private Integer purchasePrice;

    public void getPurchasePrice(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        this.purchasePrice = purchasePrice;
    }
}
