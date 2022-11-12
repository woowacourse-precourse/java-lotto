package lotto.domain;

public class LottoBuyer {
    public void checkPayUnit(int money) {
        if(money%1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }
}
