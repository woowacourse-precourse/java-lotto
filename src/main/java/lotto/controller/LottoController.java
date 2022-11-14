package lotto.controller;

import lotto.domain.*;
import lotto.view.input.LottoCreator;
import lotto.view.input.UserInput;
import lotto.view.output.Guide;

import java.util.List;
import java.util.Map;

import static lotto.util.Constants.MONETARY_UNIT;

public class LottoController {
    Guide guide = new Guide();
    UserInput userInput = new UserInput();
    LottoCreator creator = new LottoCreator();


    public void start() {
        int lottoCount = getLottoCount();
        guide.printLottoCount(lottoCount);

        Lottos lottos = getLottos(lottoCount);
        guide.printLottoGroup(lottos);

        WinningLotto winningLotto = getWinningLotto();

        int bonus = getBonus();
        winningLotto.updateBonus(bonus);

        Map<RankingType, Integer> rankingTypeCounts = lottos.getRankingTypeCounts(winningLotto);
        printResult(rankingTypeCounts);

        double profitRate = getProfitRate(rankingTypeCounts, lottoCount);
        guide.printProfitRate(profitRate);
    }

    private int getLottoCount() {
        guide.printInputPriceGuide();
        return userInput.getLottoCount();
    }

    private Lottos getLottos(int lottoCount) {
        return new Lottos(creator.createLottosCandidate(lottoCount));
    }

    private WinningLotto getWinningLotto() {
        guide.printInputWinningLottoGuide();

        List<Integer> winningNumbersCandidate =
                userInput.getWinningNumbersCandidate();
        return new WinningLotto(winningNumbersCandidate);
    }

    private int getBonus() {
        guide.printInputBonusGuide();

        return userInput.getBonusNumber();
    }

    private void printResult(Map<RankingType, Integer> rankingTypeCounts) {
        guide.printResultStartGuide();;
        guide.printResult(rankingTypeCounts);
    }

    private double getProfitRate(Map<RankingType, Integer> rankingTypeCounts, int lottoCount) {
        int investment = getInvestment(lottoCount);
        Profit profit = new Profit(rankingTypeCounts, investment);
        return profit.getProfitRate();
    }

    private int getInvestment(int lottoCount) {
        return lottoCount * MONETARY_UNIT;
    }

}
