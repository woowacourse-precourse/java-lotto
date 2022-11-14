package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 1,000 단위의 수만 입력 가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1,000 이상의 수만 입력 가능합니다.";
    private static final int UNIT_PRICE = 1000;

    private final int purchasePrice;

    public LottoMachine(String inputPrice) {
        validateType(inputPrice);
        validateRange(Integer.parseInt(inputPrice));
        validateUnit(Integer.parseInt(inputPrice));
        this.purchasePrice = Integer.parseInt(inputPrice);
    }

    private void validateType(String inputPrice) {
        if (!inputPrice.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private void validateRange(int inputPrice) {
        if (inputPrice < UNIT_PRICE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int inputPrice) {
        if (inputPrice % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    public int getRound() {
        return purchasePrice / UNIT_PRICE;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
