package lotto.constant;

public enum LottoForm {

    STARTING_NUMBER(1),
    ENDING_NUMBER(45),
    COUNT_NUMBER(6);

    private final int number;

    LottoForm(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
