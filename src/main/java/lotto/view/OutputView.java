package lotto.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoCountMessage(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<List<Integer>> lottoPapers) {
        lottoPapers.stream().forEach(System.out::println);
    }

    public void printStatisticsMessage() {
        System.out.println("당첨 통계\n---");
    }

    public void printWinningCounts(Map<String, Integer> rankingCounts) {
        System.out.println(
                "3개 일치 (5,000원) - " + rankingCounts.get("FIFTH_PLACE") + "개\n"
                + "4개 일치 (50,000원) - " + rankingCounts.get("FOURTH_PLACE") + "개\n"
                + "5개 일치 (1,500,000원) - " + rankingCounts.get("THIRD_PLACE") + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankingCounts.get("SECOND_PLACE") + "개\n"
                + "6개 일치 (2,000,000,000원) - " + rankingCounts.get("FIRST_PLACE") + "개"
        );
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.print("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
