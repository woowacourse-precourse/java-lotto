package lotto.domain;


public class Money {

    private final int pay;

    public Money(int pay) {
        validate(pay);
        this.pay = pay;
    }

    public int getPay() {
        return this.pay;
    }

    private void validate(int pay) {
        checkDivide(pay);
        checkNegative(pay);
    }

    private void checkDivide(int pay) {
        if (pay%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    private void checkNegative(int pay) {
        if (pay <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 수는 입력할 수 없습니다.");
        }
    }
}
