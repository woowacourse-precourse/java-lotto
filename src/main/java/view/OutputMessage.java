package view;

import domain.RankInfo.Rank;
import domain.RankInfo.RankInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OutputMessage {
    private static final String NUMBER_OF_PURCHASE = "개를 구매했습니다.";
    private static final String STATISTICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String MATCH_COUNT = "개 일치 (";
    private static final String MATCH_COUNT_WITH_BONUS = "개 일치, 보너스 볼 일치 (";
    private static final String REWARD = "원) - ";
    private static final String NUMBER_OF_MATCHES = "개";
    private static final String YIELD_START = "총 수익률은 ";
    private static final String YIELD_END = "%입니다.";

    public void printNumberOfPurchase(int purchaseNumber) {
        System.out.println("\n" + purchaseNumber + NUMBER_OF_PURCHASE);
    }

    public void printPurchaseLotto(String purchaseLotto) {
        System.out.println(purchaseLotto);
    }

    public void printStatistic(RankInfo rankInfo, String yield) {
        String[] separation = yield.split("\\.");

        System.out.println("\n" + STATISTICS + "\n" + DIVIDING_LINE);
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMatchCount() + setStatementType(rank)
                    + setWithComma(rank.getReward()) + REWARD + rankInfo.getMatchNumber(rank) + NUMBER_OF_MATCHES);
        }
        System.out.println(YIELD_START + setWithComma(Integer.parseInt(separation[0])) + "." + separation[1] + YIELD_END);
    }

    public String setStatementType(Rank rank) {
        if (rank == Rank.SECOND) return MATCH_COUNT_WITH_BONUS;
        return MATCH_COUNT;
    }

    public String setWithComma(int reward) {
        String rewardWithComma = String.valueOf(reward);
        Pattern pattern = Pattern.compile("(^[+-]?\\d+)(\\d{3})");
        Matcher regexMatcher = pattern.matcher(rewardWithComma);

        while(regexMatcher.find()) {
            rewardWithComma = regexMatcher.replaceAll("$1,$2");
            regexMatcher.reset(rewardWithComma);
        }
        return rewardWithComma;
    }
}
