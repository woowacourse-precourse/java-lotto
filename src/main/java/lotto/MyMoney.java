package lotto;

public class MyMoney {
    private final int amount;

    public MyMoney(String myMoney) {
        checkInputMoney(myMoney);
        this.amount = Integer.parseInt(myMoney);
    }

    private int checkIsNumber(String myMoney) {
        try {
            return Integer.parseInt(myMoney);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDivide(int moneyNum) {
        if (moneyNum % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputMoney(String myMoney) {
        int moneyNum = checkIsNumber(myMoney);
        checkIsDivide(moneyNum);
    }

    public int getAmount() {
        return this.amount;
    }
}
