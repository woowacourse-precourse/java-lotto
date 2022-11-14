package lotto.Domain;

public class Validator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    private static final int LOTTO_LENGTH = 6;

    public static final int LOTTO_PRICE = 1000;

    public static int checkIsValidateAmount(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_IS_NOT_INT);
        }
        return money;
    }

}
