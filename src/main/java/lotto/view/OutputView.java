package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {
    private static final char ARRAY_BEGIN = '[';
    private static final char ARRAY_END = ']';
    private static final String ARRAY_SEPARATOR = ", ";

    public static void printPurchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printIssuedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printNumbers(lotto);
        }
        System.out.println();
    }

    private static void printNumbers(Lotto lotto) {
        String separatedNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(ARRAY_SEPARATOR));
        System.out.println(ARRAY_BEGIN + separatedNumbers + ARRAY_END);
    }

    public static void printStatistics(List<Rank> ranks, double profitRate) {
        System.out.println("당첨 통계" + System.lineSeparator() + "---");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printStatistic(rank, countRanks(ranks, rank)));
        printProfitRate(profitRate);
    }

    private static void printStatistic(Rank rank, int lottoCount) {
        if (rank == Rank.NONE) {
            return;
        }
        String statistics = String.join(" - ", rankInformation(rank), lottoCountInformation(lottoCount));
        System.out.println(statistics);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", convertRateToPercentage(profitRate));
    }

    private static double convertRateToPercentage(double rate) {
        return rate * 100.0;
    }

    private static int countRanks(List<Rank> ranks, Rank targetRank) {
        return Math.toIntExact(ranks.stream()
                .filter(rank -> rank == targetRank)
                .count());
    }

    private static String rankInformation(Rank rank) {
        return String.join(" ", matchOf(rank), prizeOf(rank));
    }

    private static String lottoCountInformation(int lottoCount) {
        return lottoCount + "개";
    }

    private static String matchOf(Rank rank) {
        return rank.getMatchCount() + "개 일치" + bonusBallOf(rank);
    }

    private static String bonusBallOf(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private static String prizeOf(Rank rank) {
        return "(" + formatNumberWithComma(rank.getPrize()) + "원)";
    }

    private static String formatNumberWithComma(Money prize) {
        return NumberFormat.getInstance()
                .format(prize.getAmount());
    }
}
