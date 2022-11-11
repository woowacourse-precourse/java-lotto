package lotto;

public class User {
    private final int pay;

    public User(int pay) {
        validateDivide1000(pay);
        this.pay = pay;
    }

    public void validateDivide1000(int pay) {
        if (pay%1000!=0) {
            throw new IllegalArgumentException("[ERROR]: 1000원으로 나누어 떨어지지 않습니다.");
        }
    }

    public void countTicket() {

    }
}
