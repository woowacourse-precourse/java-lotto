package lotto;

public enum WIN {

    WIN_1ST(2_000_000_000),
    WIN_2ND(30_000_000),
    WIN_3RD(1_500_000),
    WIN_4TH(50_000),
    WIN_5TH(5_000);

    private final int value;

    WIN(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
