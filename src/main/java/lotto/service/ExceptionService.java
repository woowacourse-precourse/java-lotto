package lotto.service;

public class ExceptionService {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String FAILED_TO_CONVERT_NUMBER_MESSAGE = " 숫자만 입력 가능합니다.";

    public void exceptionHandlingOfPurchaseAmount(String purchaseAmount) {
        checkIfAnAmountIsConvertibleToNumber(purchaseAmount);
    }

    public static void checkIfAnAmountIsConvertibleToNumber(String purchaseAmount) {
        try {
            int money = Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + FAILED_TO_CONVERT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
