package lotto;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() {
        int inputMoney = inputView.getMoney();
        Money lottoMoney = new Money(inputMoney);

        List<Lotto> lottoTickets = lottoGenerator.makeQuickPickTicketsBy(lottoMoney);
        outputView.printTickets(lottoTickets);

        RankingService rankingService = makeRankingService();
        Rank[] rankings = rankingService.calculateRankings(lottoTickets);
        outputView.printRankingHistory(rankings);
        outputView.printRateOfReturn(rankingService.getProfitRateFrom(lottoMoney, rankings));

    }

    public RankingService makeRankingService() {
        Lotto winningNumbers = new Lotto(inputView.getWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.getBonusNumber());

        return new RankingService(winningNumbers, bonusNumber);
    }


}
