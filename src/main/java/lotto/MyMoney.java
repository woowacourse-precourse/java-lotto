package lotto;

public class MyMoney {
    private final long amount;

    public MyMoney(String myMoney) {
        checkInputMoney(myMoney);
        this.amount = Long.parseLong(myMoney);
    }

    private void checkIsZeroStart(String myMoney) {
        if (myMoney.charAt(0) == '0') {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요. (0으로 시작하는 숫자)");
        }
    }

    private long checkIsNumber(String myMoney) {
        try {
            return Long.parseLong(myMoney);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요. (문자가 포함된 입력)");
        }
    }

    private void checkIsPlus(long moneyNum){
        if(moneyNum < 0){
            throw new IllegalArgumentException("올바를 숫자를 입력해주세요. (음수)");
        }
    }

    private void checkIsDivide(long moneyNum) {
        if (moneyNum % 1000 != 0) {
            throw new IllegalArgumentException("입력값은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private void checkInputMoney(String myMoney) {
        checkIsZeroStart(myMoney);
        long moneyNum = checkIsNumber(myMoney);
        checkIsPlus(moneyNum);
        checkIsDivide(moneyNum);
    }

    public long getAmount() {
        return this.amount;
    }
}
