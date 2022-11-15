package lotto.validation;

public class InputAmountValidation {

    private static boolean isUnitFor(int unit, int inputAmount) {
        return inputAmount % unit == 0;
    }

    private static boolean isRanged(int inputAmount) {
        return 0 <= inputAmount && inputAmount <= Integer.MAX_VALUE;
    }

    public static void validateInputAmount(int inputAmount) {
        validateUnit(inputAmount);
        validateRange(inputAmount);
    }

    private static void validateRange(int inputAmount) {
        if (!isRanged(inputAmount)) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 가능한 범위를 벗어났습니다.");
        }
    }

    private static void validateUnit(int inputAmount) {
        if (!isUnitFor(1000, inputAmount)) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원 단위가 아닙니다.");
        }
    }
}
