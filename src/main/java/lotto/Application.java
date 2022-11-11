package lotto;

import lotto.controller.LottoGame;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame();
        lottoGame.startLottoGame();
    }
}
