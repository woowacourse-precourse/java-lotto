package lotto.model;


public class User {
    private int purchaseAmount;

    public User(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {

    }

    private boolean isNumber(String purchaseAmount) {
        return purchaseAmount.chars().allMatch(Character::isDigit);
    }
}
