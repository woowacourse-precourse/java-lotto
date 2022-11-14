package lotto.domain.menu;

import lotto.Lotto;
import lotto.constants.SystemConsole;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningNumberAndLotto;
import lotto.domain.subaction.WinningNumberPlace;
import lotto.input.AdditionalNumber;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

import java.util.List;

public class LottoGameMachine {

    private final LottoTickets lottoTickets;
    private final RandomLottoGenerator randomLottoGenerator;
    private final WinningNumber winningNumber;
    private final SystemConsole systemConsole;

    public LottoGameMachine(LottoTickets lottoTickets, RandomLottoGenerator randomLottoGenerator,
            WinningNumber winningNumber, SystemConsole systemConsole) {

        this.lottoTickets = lottoTickets;
        this.randomLottoGenerator = randomLottoGenerator;
        this.winningNumber = winningNumber;
        this.systemConsole = systemConsole;
    }

    public void run() {
        systemConsole.GAME_START_MESSAGE();
        int lottos = lottoTickets.getPaid();

        systemConsole.COMPLETED_PURCHASE(lottos);
        List<List<Integer>> randomLotto = randomLottoGenerator.createTicket(lottos, systemConsole);

        systemConsole.WINNING_NUMBERS();
        Lotto lottoAnswer = winningNumber.getCorrect();

        WinningNumberAndLotto winningNumberAndLotto = new WinningNumberAndLotto(new WinningNumberPlace());
        List<Integer> sameNumberCount = winningNumberAndLotto.comparison(randomLotto, lottoAnswer);

        LottoGameManagement lottoGameManagement = new LottoGameManagement(new AdditionalNumber(), new SystemConsole());
        lottoGameManagement.bonusConfirmation(randomLotto, lottoAnswer, sameNumberCount);
    }
}