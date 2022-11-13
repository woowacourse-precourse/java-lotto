package lotto;

public abstract class Number {
    private int number;
    protected Validator validator = new Validator();

    public int getNumber() {
        return this.number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    protected void validateNumber(int number) {
        this.validator.throwIfNotPositive(number);
    }
}
