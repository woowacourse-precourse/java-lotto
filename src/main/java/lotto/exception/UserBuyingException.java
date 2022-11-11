package lotto.exception;

public class UserBuyingException {
    private final static int LOTTO_PRICE = 1000;

    public void validateBuyingException(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    public void validPrice(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매는 1,000원 단위로 가능합니다.");
        }
    }

    public static void validIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
            }
        }
    }
}
