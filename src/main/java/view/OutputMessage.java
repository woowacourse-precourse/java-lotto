package view;

import domain.Rank;
import domain.RankInfo;

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

    public void printNumberOfPurchase(int purchaseNumber) {
        System.out.println("\n" + purchaseNumber + NUMBER_OF_PURCHASE);
    }

    public void printPurchaseLotto(String purchaseLotto) {
        System.out.println(purchaseLotto);
    }

    public void printStatistic(RankInfo rankInfo) {
        System.out.println("\n" + STATISTICS + "\n" + DIVIDING_LINE);
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMatchCount() + setBonusStatement(rank)
                    + setRewardWithComma(rank.getReward()) + REWARD + rankInfo.getMatchNumber(rank) + NUMBER_OF_MATCHES);
        }
    }

    public String setBonusStatement(Rank rank) {
        if (rank == Rank.SECOND) return MATCH_COUNT_WITH_BONUS;
        return MATCH_COUNT;
    }

    public String setRewardWithComma(int reward) {
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
