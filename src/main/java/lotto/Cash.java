package lotto;

public class Cash {
    private int cash;

    public Cash(int cash) {
        isValidData(cash);
        this.cash = cash;
    }

    private void isValidData(int cash) {
        final int UNIT = 1000;
        if ((cash % UNIT) != 0) {
            throw new IllegalArgumentException("1000원 단위 금액을 입력해주세요");
        }
    }

    public int getCash() {
        return cash;
    }
}
