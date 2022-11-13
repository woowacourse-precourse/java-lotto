package lotto.domain;

import lotto.Lotto;
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

    public void setUp() {
        int lottos = lottoTickets.getPaid(); // 티켓 받기
        List<List<Integer>> randomLotto = randomLottoGenerator.createTicket(lottos); // 랜덤 받기
        Lotto lottoAnswer = winningNumber.getCorrect(); // 정답 받기

        LottoAndWinningNumber lottoAndWinningNumber = new LottoAndWinningNumber();
        List<Integer> sameNumberCount = lottoAndWinningNumber.comparison(randomLotto, lottoAnswer); // 결과 받기

        LottoGameManagement lottoGameManagement = new LottoGameManagement(new AdditionalNumber());
        lottoGameManagement.bonusConfirmation(randomLotto, lottoAnswer, sameNumberCount);


        //return 0;
    }
}