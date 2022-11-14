package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Ticket;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    LottoGameService lottoGameService = new LottoGameService();

    public void start() {
        int money = InputView.inputMoney();
        int ticketCnt = new Ticket().count(money);
        OutputView.printPurchaseLotto(ticketCnt);
        List<Lotto> lottoList = lottoGameService.pickLottos(ticketCnt);
        Lotto winningNumbers = new Lotto(InputView.inputWinningNumbers());
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        giveStatistics(lottoList, winningNumbers, bonusNumber);
    }

    private void giveStatistics(List<Lotto> lottoList, Lotto winningNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeCntMap = lottoGameService.compareWinningLotto(lottoList, winningNumbers, bonusNumber);
        OutputView.printWinningHistory(prizeCntMap);
        lottoGameService.calculateProfitPercent(prizeCntMap, lottoList.size());
    }


}
