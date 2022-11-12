package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private LottoGame() {
    }

    public static LottoGame init() {
        return new LottoGame();
    }

    public void start() {
        Input.inputMoney();
    }
}
