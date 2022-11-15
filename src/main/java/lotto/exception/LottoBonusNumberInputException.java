package lotto.exception;

public class LottoBonusNumberInputException {

    private static final String PERMIT_NUM = "[0-9]+";
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;

    public void isInputValid(String number) {
        isConsistOfOnlyNumber(number);
        Integer convertedNumber = convertStringToInteger(number);
        isNumberInRange(convertedNumber);
    }

    private void isConsistOfOnlyNumber(String number) {
        if (!number.matches(PERMIT_NUM)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 이루어져야 합니다.");
        }
    }

    private Integer convertStringToInteger(String number) {
        return Integer.valueOf(number);
    }

    private void isNumberInRange(Integer userInput) {
        if (userInput < LOTTO_RANGE_START || userInput > LOTTO_RANGE_END) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이에 있어야 합니다");
        }
    }

}

