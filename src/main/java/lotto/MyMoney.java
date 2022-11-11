package lotto;

public class MyMoney {
    private final int amount;

    public MyMoney(String myMoney) {
        checkInputMoney(myMoney);
        this.amount = Integer.parseInt(myMoney);
    }

    private void checkIsZeroStart(String myMoney) {
        if (myMoney.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }
    }

    private int checkIsNumber(String myMoney) {
        try {
            return Integer.parseInt(myMoney);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsPlus(int moneyNum){
        if(moneyNum < 0){
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDivide(int moneyNum) {
        if (moneyNum % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputMoney(String myMoney) {
        checkIsZeroStart(myMoney);
        int moneyNum = checkIsNumber(myMoney);
        checkIsPlus(moneyNum);
        checkIsDivide(moneyNum);
    }

    public int getAmount() {
        return this.amount;
    }
}
