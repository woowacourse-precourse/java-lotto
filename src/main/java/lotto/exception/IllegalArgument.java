package lotto.exception;

public class IllegalArgument {

    public static boolean isNumber(String purchaseAmount) throws IllegalArgumentException {
        purchaseAmount = purchaseAmount.replaceAll(",", "");
        if (!purchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다.");
        }
        return true;
    }
}
