package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.RankResult;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {
    private static final String START = "개를 구매했습니다.";
    private static final String START_STATICS = "당첨 통계";

    private static final String LINE = "\n---";

    private static final String STATIC_PART1 = "개 일치 (";

    private static final String STATIC_BONUS_PART = "개 일치, 보너스 볼 일치 (";

    private static final String STATIC_PART2 = "원)";

    private static final String STATIC_PART3 = " - ";

    private static final String STATIC_PART4 = "개";

    public static void printLottery(LottoResult resultVale) {
        System.out.println(resultVale.getLotteryCount() + START);
        resultVale.getLottoResult().forEach(autoLotto -> System.out.println(autoLotto.toString()));
    }

    public static void printStatistics(RankResult rankResult) {
        System.out.printf("%s%s%n", START_STATICS, LINE);
        System.out.println(fifth(rankResult));
        System.out.println(fourth(rankResult));
        System.out.println(third(rankResult));
        System.out.println(second(rankResult));
        System.out.println(first(rankResult));
        System.out.printf("총 수익률은 %s%%입니다.", rankResult.yield());
    }

    private static String fifth(RankResult rankResult) {
        return rankResult.getRankResult().entrySet().stream()
                .filter(rankIntegerEntry -> rankIntegerEntry.getKey() == Rank.FIFTH)
                .map(convertString(STATIC_PART1))
                .collect(Collectors.joining());
    }

    private static String fourth(RankResult rankResult) {
        return rankResult.getRankResult().entrySet().stream()
                .filter(rankIntegerEntry -> rankIntegerEntry.getKey() == Rank.FOURTH)
                .map(convertString(STATIC_PART1))
                .collect(Collectors.joining());
    }

    private static String third(RankResult rankResult) {
        return rankResult.getRankResult().entrySet().stream()
                .filter(rankIntegerEntry -> rankIntegerEntry.getKey() == Rank.THIRD)
                .map(convertString(STATIC_PART1))
                .collect(Collectors.joining());
    }

    private static String second(RankResult rankResult) {
        return rankResult.getRankResult().entrySet()
                .stream().filter(rankIntegerEntry -> rankIntegerEntry.getKey() == Rank.SECOND)
                .map(convertString(STATIC_BONUS_PART))
                .collect(Collectors.joining());
    }

    private static String first(RankResult rankResult) {
        return rankResult.getRankResult().entrySet().stream()
                .filter(rankIntegerEntry -> rankIntegerEntry.getKey() == Rank.FIRST)
                .map(convertString(STATIC_PART1))
                .collect(Collectors.joining());
    }

    private static Function<Map.Entry<Rank, Integer>, String> convertString(String staticPart) {
        return result -> result.getKey().getMatchNumber() + staticPart + result.getKey().getReward()
                + STATIC_PART2 + STATIC_PART3 + result.getValue() + STATIC_PART4;
    }

}
