package lotto;

public class Money {

    private final int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public int moneyDivide1000() {
        return money / 1000;
    }

    private void validateMoney(String money) {
        int realMoney = Integer.parseInt(money);
        validateOverZero(realMoney);
        validateDivide1000(realMoney);
    }

    private void validateDivide1000(int realMoney) {
        if (realMoney % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위의 금액을 입력해야 합니다.");
        }
    }

    private void validateOverZero(int realMoney) {
        if (realMoney < 0) {
            throw new IllegalArgumentException("알맞은 금액을 입력하세요.");
        }
    }

}
