package lotto;

import constant.Amount;
import constant.LottoText;

public class Convert {
    private final Validate validate = new Validate();

    public int toLottoCount(int purchasePrice) {
        validate.validDivisible(purchasePrice);
        return purchasePrice / Amount.UNIT.getPrice();
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoText.ERROR + "입력값을 정수로 변환할 수 없습니다.");
        }
    }
}
