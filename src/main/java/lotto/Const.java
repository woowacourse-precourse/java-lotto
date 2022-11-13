package lotto;

public enum Const {
    SIZE(6);

    private final int number;

    Const(int number) {
        this.number = number;
    }

    public boolean equals(int compareNumber) {
        return this.number == compareNumber;
    }
}
