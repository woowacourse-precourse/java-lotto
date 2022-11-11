package lotto.domain;


public class Statistics {

    public static final String REG_XP_DIGITS = "^[0-9]+$";
    private final int purchaseAmount;

    public Statistics(int purchaseAmount) {
        hasDigitsOnly(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void hasDigitsOnly(int purchaseAmount) {
        String money = String.valueOf(purchaseAmount);
        if (!money.matches(REG_XP_DIGITS)) {
            System.out.println("[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
