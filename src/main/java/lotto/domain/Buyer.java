package lotto.domain;

public class Buyer {
    public Buyer() {}

    public long countLottos (long money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위만 가능합니다");
        }

        return money / 1000;
    }
}
