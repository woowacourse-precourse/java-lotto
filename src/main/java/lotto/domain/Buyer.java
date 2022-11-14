package lotto.domain;

public class Buyer {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    int lottoAmount;

    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    static void validDivisionByThousand(int purchaseAmount){
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
