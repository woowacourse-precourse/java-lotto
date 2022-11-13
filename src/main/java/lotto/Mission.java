package lotto;

import static lotto.utils.Constant.LOTTO_PRICE;

import java.util.EnumMap;
import java.util.List;
import lotto.controller.MoneyController;
import lotto.controller.WinningController;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import lotto.view.Output;

public class Mission {

    Output output;
    LottoMaker lottoMaker;
    ResultRepository repository;

    MoneyController moneyController;
    WinningController winningController;

    Mission() {
        output = new Output();
        lottoMaker = new LottoMaker();
        repository = new ResultRepository();
        moneyController = new MoneyController();
        winningController = new WinningController();

        try {
            play();
        } catch (IllegalArgumentException e) {
            Output.printErrorAndExit(e.getMessage());
        }
    }

    private void play() {
        Money money = getMoney();

        int many = calculateHowManyLotto(money);
        List<Lotto> lottos = lottoMaker.getLottos(many);
        output.printLottos(lottos);

        WinningLotto winningLotto = winningController.getWinningLotto();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            repository.add(rank);
        }

        int priceMoney = repository.getTotalMoney();

        output.printLottoResultTitle();
        EnumMap<Rank, Integer> result = repository.getResult();
        result.forEach(this::callOutputAboutRank);

        double rate = getRate(money.getMoney(), priceMoney);

        output.printTotalRate(rate);
    }

    private Money getMoney() {
        output.printGetMoney();
        return moneyController.getMoney();
    }

    private int calculateHowManyLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    private double getRate(int inputMoney, int priceMoney) {
        double result = (double) priceMoney / inputMoney;
        result *= 100;
        return result;
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
}
