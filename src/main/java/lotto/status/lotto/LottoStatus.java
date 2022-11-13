package lotto.status.lotto;

public enum LottoStatus {
    startInclusive(1),
    endInclusive(45),
    count(6);

    private int value;

    LottoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
