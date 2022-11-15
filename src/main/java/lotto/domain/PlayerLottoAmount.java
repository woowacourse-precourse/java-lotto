package lotto.domain;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";

    private final int amount;

    public PlayerLottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_MIN_AMOUNT;
    }


    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private static int validateNumber(String amount) throws IllegalArgumentException{
        try {
            return Integer.parseInt(amount);
        }catch (NumberFormatException e){
            System.out.println(NOT_NUMBER_ERROR);
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }


    private void validateNatural(int amount) {
        if (amount <= 0) {
            System.out.println(NOT_NATURAL_NUMBER_ERROR);
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_NUMBER_ERROR);
        }
    }

}
