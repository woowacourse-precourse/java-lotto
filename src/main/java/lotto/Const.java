package lotto;

public enum Const {
    SIZE(6),
    BILL(1000),
    MINUS(3);

    private final int number;

    Const(int number) {
        this.number = number;
    }

    public boolean equals(int compareNumber) {
        return this.number == compareNumber;
    }

    public int getNumber() {
        return this.number;
    }
}
