package lotto;

import lotto.constants.SystemConsole;
import lotto.domain.menu.LottoGameMachine;
import lotto.domain.RandomLottoGenerator;
import lotto.input.WinningNumber;

public class Application {

    public static void main(String[] args) {
        LottoGameMachine lottoGameMachine = new LottoGameMachine(new RandomLottoGenerator(), new WinningNumber(), new SystemConsole());
        lottoGameMachine.run();
    }
}
