package lotto.view;

import lotto.domian.lotto.LottoGenerator;
import lotto.domian.statistics.Prize;
import lotto.domian.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int THOUSAND_WON = 1000;
    private static final int ZERO = 0;

    private LottoView lottoView = new LottoView();
    private List<List<Integer>> lottos = new ArrayList<>();
    private List<Integer> winningNumber;
    private int bonusNumber;

    public void printAllResult() {
        buyNewLottos();
        getWinningNumberAndBonusNumber();
        lottosStatistics();
    }

    public void buyNewLottos() {
        int money = lottoView.getMoney();
        System.out.println();
        returnLottosNumbers(money / THOUSAND_WON);
    }

    public void getWinningNumberAndBonusNumber() {
        System.out.println();
        winningNumber = lottoView.getWinningNumber();
        System.out.println();
        bonusNumber = lottoView.getBonusNumber(winningNumber);
    }

    public void lottosStatistics() {
        lottoView.printStatisticsPhrase();
        Statistics statistics = new Statistics(winningNumber, bonusNumber);
        Map<Integer, Integer> numberOfEachGrade = statistics.getNumberOfEachGrade(lottos);
        returnNumberOfEachGrade(numberOfEachGrade);
        lottoView.printRateOfReturn(statistics.getProfit(lottos));
    }

    private void returnNumberOfEachGrade(Map<Integer, Integer> numberOfEachGrade) {
        for (Prize prize : Prize.values()) {
            int countGrade = ZERO;
            if (numberOfEachGrade.containsKey(Prize.getGradeNum(prize))) {
                countGrade = numberOfEachGrade.get(Prize.getGradeNum(prize));
            }
            lottoView.printNumberOfEachGrade(Prize.getPhrase(prize), countGrade);
        }
    }

    private void returnLottosNumbers(int count) {
        lottoView.printLottosNumbers(count);
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottos = lottoGenerator.generateLotto(count);
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
