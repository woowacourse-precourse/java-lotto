package lotto;

public class Amount {
    private static final int thousandWon = 1000;
    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public boolean isValidateAmount() {
        if(amount%thousandWon == 0) return true;
        return false;
    }

    public int getLottoCount() {
        return amount/thousandWon;
    }
}
