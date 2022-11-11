package lotto.domain;

public enum BonusNumber {
    BONUS_NUMBER(1);

    private int number;

    BonusNumber(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
