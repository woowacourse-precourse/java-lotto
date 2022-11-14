package lotto.domain;

public class Buyer {
    int lottoAmount;

    static void validConsistByNumber(String purchaseAmount){
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
