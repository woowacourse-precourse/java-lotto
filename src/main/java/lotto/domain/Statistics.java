package lotto.domain;


public class Statistics {

    public static final String REG_XP_DIGITS = "^[0-9]+$";
    private final int purchaseAmount;

    public Statistics(String purchaseAmount) {
        hasDigitsOnly(purchaseAmount);
        int money = Integer.parseInt(purchaseAmount);
        isDividedByLottoAmount(money);
        this.purchaseAmount = money;
    }

    private void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(REG_XP_DIGITS)) {
            System.out.println("[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            System.out.println("[ERROR] 금액은 로또 한장의 가격인 1000원 단위로만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
