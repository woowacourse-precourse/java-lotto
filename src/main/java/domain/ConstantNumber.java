package domain;

public enum ConstantNumber {
    VALID_MONEY(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);
    final int number;

    ConstantNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
