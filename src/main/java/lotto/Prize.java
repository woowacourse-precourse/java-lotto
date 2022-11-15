package lotto;

public enum Prize {
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000),
    Invalid(0);

    private int value;

    private Prize(int value) {
        this.value = value;
    }

    public int getPrizeMoney() {
        return value;
    }
}
