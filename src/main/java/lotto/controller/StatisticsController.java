package lotto.controller;

import lotto.input.InputBonusNumber;
import lotto.input.InputWinningNumbers;
import lotto.model.BonusNumber;
import lotto.model.Prize;
import lotto.model.Ticket;
import lotto.model.WinningLotto;
import lotto.service.LottoResultService;
import lotto.view.StatisticsView;

import java.util.List;
import java.util.Map;

public class StatisticsController {
    public static Map<Prize, Integer> run(Ticket ticket) {
        List<Integer> winningNumbers = InputWinningNumbers.input();
        BonusNumber bonusNumber = InputBonusNumber.input();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Map<Prize, Integer> statistics = LottoResultService.getStatistics(ticket, winningLotto);
        StatisticsView.outPut(statistics);
        return statistics;
    }
}
