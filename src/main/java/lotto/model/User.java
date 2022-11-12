package lotto.model;

public class User {
    private int purchaseAmount;

    public User(String purchaseAmount) {
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }
}
