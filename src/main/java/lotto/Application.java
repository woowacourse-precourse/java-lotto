package lotto;

import lotto.mvc.util.LottoGameStatus;

public class Application {
    public static void main(String[] args) {
        GameRunner.run(LottoGameStatus.GUIDE_PURCHASE_AMOUNT);
    }
}
