package lotto.domain;

public class LottoPieces {

    public final int pieces;

    public LottoPieces(int money) {
        validateMoney(money);
        int pieces = money / 1000;
        this.pieces = pieces;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천 원 단위로만 구매가 가능합니다");
        }
    }
}
