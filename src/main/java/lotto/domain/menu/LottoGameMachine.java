package lotto.domain.menu;

import lotto.Lotto;
import lotto.constants.SystemConsole;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningNumberAndLotto;
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
        int lottos = getLottos();

        List<List<Integer>> randomLotto = getRandomLotto(lottos);

        Lotto lottoAnswer = getCorrectLottoNumber();

        List<Integer> sameNumberCount = getSameNumberCount(randomLotto, lottoAnswer);
        LottoGameManagement lottoGameManagement = new LottoGameManagement(
                new AdditionalNumber(), new SystemConsole());

        lottoGameManagement.bonusConfirmation(randomLotto, lottoAnswer, sameNumberCount);
    }

    private Lotto getCorrectLottoNumber() {
        systemConsole.winningNumbers();
        return winningNumber.getCorrect();
    }

    private List<List<Integer>> getRandomLotto(int lottos) {
        systemConsole.completedPurchase(lottos);
        return randomLottoGenerator.createTicket(lottos);
    }

    public int getLottos() {
        systemConsole.gameStartMessage();
        LottoTickets lottoTickets = new LottoTickets();
        return lottoTickets.getPaid();
    }

    private List<Integer> getSameNumberCount(List<List<Integer>> randomLotto, Lotto lottoAnswer) {
        WinningNumberAndLotto winningNumberAndLotto = new WinningNumberAndLotto();
        return winningNumberAndLotto.comparison(randomLotto, lottoAnswer);
    }
}