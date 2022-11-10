package lotto;

import constant.LottoText;

public class Convert {
    Validate validate = new Validate();
    public int toPurchasePrice(String input) {
        int purchasePrice = toInt(input);
        validate.validDivisible(purchasePrice);
        return purchasePrice;
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoText.ERROR + "입력값을 정수로 변환할 수 없습니다.");
        }
    }
}
