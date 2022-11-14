package lotto.domain;

public enum BonusNumber {
    BONUS_NUMBER(0);

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
