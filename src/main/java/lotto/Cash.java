package lotto;

public class Cash {
    private int cash;

    public Cash(int cash) {
        isValidData(cash);
        this.cash = cash;
    }

    private void isValidData(int cash) throws IllegalArgumentException {
        final int UNIT = 1000;

        if(cash <= 0){
            throw new IllegalArgumentException("양수만 허용합니다");
        }
        if ((cash % UNIT) != 0) {
            throw new IllegalArgumentException("1000원 단위 금액을 입력해주세요");
        }
    }

    public int getCash() {
        return cash;
    }
}
