package lotto.exception;

import java.util.NoSuchElementException;

public class PurchaseException {
    private final static int LOTTO_PRICE = 1000;
    private final static String ERROR = "[ERROR] ";

    public void isValidPurchase(String amount) {
        isOnlyNumber(amount);
        isValidPrice(amount);
    }

    public static void isOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println(ERROR + "입력은 숫자만 가능합니다.");
                throw new NoSuchElementException();
            }
        }
    }

    public void isValidPrice(String pay) {
        int amount = Integer.parseInt(pay);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR + "구매는 1,000원 단위로 가능합니다.");
        }
    }
}