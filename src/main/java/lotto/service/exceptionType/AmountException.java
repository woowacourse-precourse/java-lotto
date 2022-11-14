package lotto.service.exceptionType;

public class AmountException {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String FAILED_TO_CONVERT_NUMBER_MESSAGE = " 숫자만 입력 가능합니다.";
    public static final String INDIVISIBLE_EXCEPTION_MESSAGE = " 1000원 단위로만 입력 가능합니다.";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = " 1000원 이상만 입력 가능합니다.";

    public void checkIfAnAmountIsConvertibleToNumber(String purchaseAmount) {
        try {
            int money = Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + FAILED_TO_CONVERT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkIfAmountIsDivisibleByOneThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
            System.out.println(ERROR_MESSAGE + INDIVISIBLE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkIfAmountIsPositive(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < 0) {
            System.out.println(ERROR_MESSAGE + NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
