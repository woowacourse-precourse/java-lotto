package lotto.domain;

public class Player {
    private final int payment;



    private final int lottoCount;
    final int WON_UNIT = 1000;

    public Player(int money) {
        validateWonUnit(money);
        this.payment = money;
        this.lottoCount = money / WON_UNIT;
    }

    private void validateWonUnit(int money) {
        final String WON_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위만 가능합니다.";

        if (money % WON_UNIT != 0) {
            throw new IllegalArgumentException(WON_UNIT_ERROR_MESSAGE);
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
