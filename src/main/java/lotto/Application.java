package lotto;

import lotto.domain.LottoGame;
import lotto.domain.RandomLottoGenerator;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoTickets(),
                                            new RandomLottoGenerator(),
                                            new WinningNumber());
        lottoGame.setUp();
    }
}
