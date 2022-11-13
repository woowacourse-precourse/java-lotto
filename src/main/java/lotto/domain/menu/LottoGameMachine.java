package lotto.domain.menu;

import lotto.Lotto;
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

    public LottoGameMachine(LottoTickets lottoTickets, RandomLottoGenerator randomLottoGenerator, WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.randomLottoGenerator = randomLottoGenerator;
        this.winningNumber = winningNumber;
    }

    public void run() {
        int lottos = lottoTickets.getPaid();
        List<List<Integer>> randomLotto = randomLottoGenerator.createTicket(lottos);
        Lotto lottoAnswer = winningNumber.getCorrect();

        WinningNumberAndLotto winningNumberAndLotto = new WinningNumberAndLotto(new WinningNumberPlace());
        List<Integer> sameNumberCount = winningNumberAndLotto.comparison(randomLotto, lottoAnswer);

        LottoGameManagement lottoGameManagement = new LottoGameManagement(new AdditionalNumber());
        lottoGameManagement.bonusConfirmation(randomLotto, lottoAnswer, sameNumberCount);
    }
}