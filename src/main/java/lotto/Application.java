package lotto;

import lotto.domain.LottoManager;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.gameStart();
    }
}
