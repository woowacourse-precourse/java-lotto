package lotto;

public enum PrizeMoney {
    FIRST("1등", 2000000000),
    SECOND("2등", 30000000),
    THIRD("3등", 1500000),
    FOURTH("4등", 50000),
    FIFTH("5등", 5000);

    private final String place;
    private final int reward;

    PrizeMoney(String place, int reward) {
        this.place = place;
        this.reward = reward;
    }

    String label() {
        return this.place;
    }
    int value() {
        return this.reward;
    }
}
