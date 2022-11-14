package lotto.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class Output {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public static void printResult(List<Result> results) {
        Map<Result, Integer> resultTable = getResultTable(results);
        System.out.println("3개 일치 (5,000원) - " + resultTable.getOrDefault(Result.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultTable.getOrDefault(Result.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultTable.getOrDefault(Result.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultTable.getOrDefault(Result.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultTable.getOrDefault(Result.FIRST, 0) + "개");
    }

    public static void printRate(List<Result> results) {
        double rate = getRate(results);
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "% 입니다.");
    }

    private static double getRate(List<Result> results) {
        long totalPrizeMoney = results
            .stream()
            .mapToLong(Result::getPrizeMoney)
            .sum();
        long investMoney = results.size() * 1000L;

        return (double) totalPrizeMoney / investMoney * 100;
    }

    private static Map<Result, Integer> getResultTable(List<Result> results) {
        Map<Result, Integer> resultTable = new HashMap<>();

        for (Result result : results) {
            int count = resultTable.getOrDefault(result, 0);
            resultTable.put(result, count + 1);
        }
        return resultTable;
    }
}
