package lotto;

public class Money {
    public static final String ERROR_MONEY = "[ERROR] 금액은 1 이상의 자연수여야 합니다.";
    private int money;

    private void validMoney(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }
}
