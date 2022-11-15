package lotto.domain;

public class LottoCashier {
    public int getLottoCount(int money) {
        if (money > 0 && money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입해야 합니다.");
            }
        return money / 1000;
    }
}
