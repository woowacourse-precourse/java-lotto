package lotto.utils;

import lotto.domain.Lotto;

public class UserInputValidator {

    public static final int UNIT_OF_MONEY = 1000;
    public static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY = "[ERROR] 구입 금액은 1000원 단위만 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복된 숫자를 포함해서는 안됩니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE = "[ERROR] 로또 번호는 단 6개만 입력 가능합니다.";

    public static void validatePurchaseAmount(String purchaseAmount) {
        isDigit(purchaseAmount);
        isValidUnitOfMoney(Integer.parseInt(purchaseAmount));
    }

    public static void validateLottoNumber(String lottoNumber) {
        isDigit(lottoNumber);
        isValidLottoNumber(Integer.parseInt(lottoNumber));
    }

    public static void validateLottoSize(String[] lottoNumbers) {
        if (lottoNumbers.length != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE);
        }
    }

    private static void isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidUnitOfMoney(int purchaseAmount) {
        if (purchaseAmount % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY);
        }
    }

    private static void isValidLottoNumber(int lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || Lotto.MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
        }
    }
}
