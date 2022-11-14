package lotto.enumeration;

public enum LottoInformation {
    START_LOTTO_NUMBER_RANGE(1),
    END_LOTTO_NUMBER_RANGE(45),
    LOTTO_NUMBERS(6),
    LOTTO_PRICE(1000);

    private final int informationNumber;

    LottoInformation(int informationNumber) {
        this.informationNumber = informationNumber;
    }

    public int toInteger() {
        return informationNumber;
    }

}
