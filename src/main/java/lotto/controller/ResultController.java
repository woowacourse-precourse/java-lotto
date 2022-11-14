package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import lotto.view.Output;

public class ResultController {

    private final WinningLotto winningLotto;
    private final List<Lotto> lottos;
    ResultRepository repository;
    Output output;

    public ResultController(WinningLotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        repository = new ResultRepository();
        output = new Output();
    }

    public void sratchLottos() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            repository.add(rank);
        }
    }

    public void printRate(Money inputMoney) {
        int priceMoney = repository.getTotalMoney();
        double rate = getRate(inputMoney.getMoney(), priceMoney);
        output.printTotalRate(rate);
    }

    public void printResult() {
        output.printLottoResultTitle();
        EnumMap<Rank, Integer> result = repository.getResult();
        result.forEach(this::callOutputAboutRank);
    }

    private void callOutputAboutRank(Rank rank, Integer count) {
        if (rank == Rank.ZERO) {
            return;
        }
        if (rank == Rank.SECOND) {
            output.printLottoResultAboutRankWithBonus(rank.getCountOfMatch(), rank.getMoney(), count);
            return;
        }
        output.printLottoResultAboutRank(rank.getCountOfMatch(), rank.getMoney(), count);
    }

    private double getRate(int inputMoney, int priceMoney) {
        double result = (double) priceMoney / inputMoney;
        result *= 100;
        return result;
    }
}
