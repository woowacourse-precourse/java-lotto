package lotto.view;

import lotto.domain.Ranking;
import lotto.domain.Result;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    static final String OUTPUT_RESULT_TITLE = "당첨 통계";
    static final String OUTPUT_RESULT_LINE = "---";

    public Output() {
    }

    public static void printTitle() {
        System.out.println(OUTPUT_RESULT_TITLE);
        System.out.println(OUTPUT_RESULT_LINE);
    }

    public static void printWinningStatistic(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Ranking, Integer> entry : getResultEntryList(result)) {
            Ranking nowRanking = entry.getKey();
            int count = entry.getValue();
            makeWinningResult(nowRanking, count, stringBuilder);
        }
        System.out.println(stringBuilder);
    }

    private static List<Map.Entry<Ranking, Integer>> getResultEntryList(Result result) {
        return result.getResult().entrySet().stream()
                .filter(set -> set.getKey() != Ranking.NOTHING)
                .sorted(Comparator.comparingInt(i -> i.getKey().getMoney()))
                .collect(Collectors.toList());
    }

    private static void makeWinningResult(Ranking ranking, int count, StringBuilder stringBuilder) {
        String winningTitle = String.format("%d개 일치", ranking.getCount());
        stringBuilder.append(winningTitle);

        if(ranking.isHasBonusNumber()) {
            String hasBonus = ", 보너스 볼 일치";
            stringBuilder.append(hasBonus);
        }

        String winningMoney = String.format(" (%d원) - %d개", ranking.getMoney(), count);
        stringBuilder.append(winningMoney).append("\n");
    }

}
