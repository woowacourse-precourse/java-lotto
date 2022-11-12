package lotto.domain;

public class LottoMachine {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 1,000 단위의 수만 입력 가능합니다.";

    private static final int UNIT_PRICE = 1000;

    private final int purchasePrice;

    public LottoMachine(String inputPrice) {
        validateRange(inputPrice);
        this.purchasePrice = Integer.parseInt(inputPrice);
        validateUnit();
    }

    public void validateRange(String inputPrice) {
        if (!inputPrice.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    public void validateUnit() {
        if (purchasePrice % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }
}
