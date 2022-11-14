package lotto.domain;

public class Amount {
    private static final int REMAINDER_VALUE = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_CANT_DIVIDE_INTO_1000_MESSAGE = "[ERROR] 금액은 " + LOTTO_PRICE + "원 단위로만 입력 가능합니다.";
    int value;

    public Amount(int value) {
        validateCanDivideIntoOneThousand(value);
        this.value = value;
    }

    private void validateCanDivideIntoOneThousand(int amount) {
        if (amount % LOTTO_PRICE == REMAINDER_VALUE) {
            return;
        }
        System.out.println(ERROR_CANT_DIVIDE_INTO_1000_MESSAGE);
        throw new IllegalArgumentException(ERROR_CANT_DIVIDE_INTO_1000_MESSAGE);
    }

    public int calculateLottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}
