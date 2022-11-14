package lotto.domain.menu;

import lotto.Lotto;
import lotto.constants.ExceptionConsole;
import lotto.constants.SystemConsole;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningNumberAndLotto;
import lotto.domain.exception.AmountPaymentException;
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
        List<List<Integer>> randomLotto = getRandomLotto();

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

    private List<List<Integer>> getRandomLotto() {
        AmountPaymentException amountPaymentException = new AmountPaymentException(
                new ExceptionConsole());

        return randomLotto(amountPaymentException);
    }

    private List<List<Integer>> randomLotto(AmountPaymentException amountPaymentException) {
        LottoTickets lottoTickets = new LottoTickets();
        int lottos = lottoTickets.getPaid(amountPaymentException);

        systemConsole.completedPurchase(lottos);
        return randomLottoGenerator.createTicket(lottos);
    }
}