package lotto;

import lotto.domain.LottoGameMachine;
import lotto.domain.RandomLottoGenerator;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

public class Application {

    public static void main(String[] args) {
        LottoGameMachine lottoGameMachine = new LottoGameMachine(new LottoTickets(), new RandomLottoGenerator(), new WinningNumber());
        lottoGameMachine.setUp();
    }
}
