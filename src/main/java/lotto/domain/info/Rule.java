package lotto.domain.info;

public enum Rule {
    START_NUMBER(1),
    END_NUMBER(45),
    NUMBER_COUNT(6);

    private final int number;
    Rule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
