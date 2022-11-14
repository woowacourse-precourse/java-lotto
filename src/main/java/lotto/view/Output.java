package lotto.view;

import lotto.domain.Rank;

import java.util.LinkedHashMap;

public class Output {
    private static final String STATICS_MESSAGE = "당첨 통계\n" + "---\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printStatics(LinkedHashMap<Rank, Integer> winningResult) {
        System.out.printf(System.lineSeparator() + STATICS_MESSAGE);
        for (MatchMessage matchMessage : MatchMessage.values()) {
            System.out.printf(matchMessage.message() + "\n",
                    winningResult.get(Rank.valueOf(matchMessage.toString())));
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE, earningRate);
    }
}