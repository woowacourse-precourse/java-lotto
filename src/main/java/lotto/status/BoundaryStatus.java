package lotto.status;

public enum BoundaryStatus {
    START_NUMBER(0),
    WINNING_RESULT_LENGTH(8),
    MIN_WINNING_COUNT(3),
    ZERO_ASCII(48),
    NINE_ASCII(57);


    private int number;

    BoundaryStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
