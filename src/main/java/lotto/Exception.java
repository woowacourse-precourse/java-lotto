package lotto;

public class Exception {
    public void validMoney(int money) {
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요.");
    }
    public void
}
