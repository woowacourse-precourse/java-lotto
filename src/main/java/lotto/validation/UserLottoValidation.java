package lotto.validation;

public class UserLottoValidation {
    private static final int LOTTO_BASE_PRICE = 1000;
    private static final String ERROR_NOT_VALID_MONEY = "[ERROR] 유효하지 않은 금액입니다.";

    public static void canBuyLotto(int userMoney) {
        if (userMoney < LOTTO_BASE_PRICE || (userMoney % LOTTO_BASE_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MONEY);
        }
    }
}
