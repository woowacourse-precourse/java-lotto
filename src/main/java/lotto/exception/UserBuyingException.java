package lotto.exception;

public class UserBuyingException {
    private final static int LOTTO_PRICE = 1000;

    public void validateBuyingException(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    public void validBuyingException(int buyingMoney) {
        if (buyingMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매는 1,000원 단위로 가능합니다.");
        }
    }

    public void validPrice(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매는 1,000원 단위로 가능합니다.");
        }
    }

    static boolean validIsNumber(String s) { //정수 판별 함수
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
