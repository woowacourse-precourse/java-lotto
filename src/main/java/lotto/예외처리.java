package lotto;

public class 예외처리 {
    public static boolean isNumeric(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            if (!Character.isDigit(purchaseAmount.charAt(i)))
                return false;
        }
        return true;
    }

}
