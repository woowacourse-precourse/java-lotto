package lotto;

public abstract class Number {
    private int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public abstract void validate();
}
