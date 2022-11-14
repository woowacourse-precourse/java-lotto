package lotto.view;

import lotto.domian.lotto.LottoGenerator;
import lotto.domian.statistics.Prize;
import lotto.domian.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private LottoView lottoView = new LottoView();
    private Statistics statistics;
    private List<List<Integer>> lottos = new ArrayList<>();
    private List<Integer> winningNumber;
    private int money;
    private int bonusNumber;

    public void buyNewLottos() {
        money = lottoView.getMoney();
        System.out.println();
        printLottosNumbers(money / 1000);
    }

    public void getWinningNumberAndBonusNumber() {
        System.out.println();
        winningNumber = lottoView.getWinningNumber();
        System.out.println();
        bonusNumber = lottoView.getBonusNumber(winningNumber);
    }

    public void lottosStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        statistics = new Statistics(winningNumber, bonusNumber);
        Map<Integer, Integer> numberOfEachGrade = statistics.getNumberOfEachGrade(lottos);
        printNumberOfEachGrade(numberOfEachGrade);
        System.out.println("총 수익률은 " + statistics.getProfit(lottos) + "%입니다.");
    }

    private void printNumberOfEachGrade(Map<Integer, Integer> numberOfEachGrade) {
        for (Prize prize : Prize.values()) {
            int countGrade = 0;
            if (numberOfEachGrade.containsKey(Prize.getGradeNum(prize))) {
                countGrade = numberOfEachGrade.get(Prize.getGradeNum(prize));
            }
            System.out.println(Prize.getPhrase(prize) + countGrade + '개');
        }
    }

    public void printLottosNumbers(int count) {
        System.out.println(count + "개를 구매했습니다.");
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottos = lottoGenerator.generateLotto(count);
        for (List lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
