package lotto.domain;

public class LottoPurchaseCount {

    public static int getLottoCount(int money) {
        isCorrectMoney(money);
        return getMoney(money);
    }

    private static int getMoney(int money) {
        if (money % 1000 == 0) {
            money /= 1000;
        }
        return money;
    }

    private static void isCorrectMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
}
