package lotto.domain;

public class Purchase {
    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public boolean isValid(int money) {
        return money % 1000 == 0;
    }

    public int canBuyLotto() {
        return 0;
    }
}
