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
    private final RandomLottoGenerator randomLottoGenerator;
    private final WinningNumber winningNumber;
    private final SystemConsole systemConsole;

    public LottoGameMachine(RandomLottoGenerator randomLottoGenerator,
            WinningNumber winningNumber, SystemConsole systemConsole) {

        this.randomLottoGenerator = randomLottoGenerator;
        this.winningNumber = winningNumber;
        this.systemConsole = systemConsole;
    }

    public void run() {
        systemConsole.gameStartMessage();
        LottoTickets lottoTickets = new LottoTickets();
        int lottos = lottoTickets.getPaid();

        systemConsole.completedPurchase(lottos);
        List<List<Integer>> randomLotto = randomLottoGenerator.createTicket(lottos);

        systemConsole.winningNumbers();
        Lotto lottoAnswer = winningNumber.getCorrect();

        List<Integer> sameNumberCount = getSameNumberCount(randomLotto, lottoAnswer);
        LottoGameManagement lottoGameManagement = new LottoGameManagement(
                new AdditionalNumber(), new SystemConsole());

        lottoGameManagement.bonusConfirmation(randomLotto, lottoAnswer, sameNumberCount);
    }

    private List<Integer> getSameNumberCount(List<List<Integer>> randomLotto, Lotto lottoAnswer) {
        WinningNumberAndLotto winningNumberAndLotto = new WinningNumberAndLotto(
                new WinningNumberPlace());

        return winningNumberAndLotto.comparison(randomLotto, lottoAnswer);
    }
}