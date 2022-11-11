package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void showStaistics(List<Lotto> generatedLottos, WinLotto winLotto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int count = generatedLottos.size();
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : generatedLottos) {
            Result result = winLotto.getResult(lotto);
            results.add(result);
        }

        ResultStatistics statistics = new ResultStatistics(results);
        System.out.println(statistics.printResultStatistics());
        float totalProfitRate = Math.round((float) (statistics.getTotalProfit()) / (count * 1000) * 1000) / 10f;
        System.out.println("statistics.getTotalProfit() = " + statistics.getTotalProfit());
        System.out.println("(count * 1000) = " + (count * 1000));

        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
