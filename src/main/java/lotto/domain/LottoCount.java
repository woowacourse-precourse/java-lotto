package lotto.domain;

public class LottoCount {

    public int getLottoCount(int money) {
        isCorrectMoney(money);
        return getMoney(money);
    }

    private int getMoney(int money) {
        if (money % 1000 == 0) {
            money /= 1000;
        }
        return money;
    }

    private void isCorrectMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
}
