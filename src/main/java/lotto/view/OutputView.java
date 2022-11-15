package lotto.view;

import lotto.constant.LotteryRank;
import lotto.domain.constant.LottoProperty;
import lotto.view.constant.Format;
import lotto.view.constant.PurchasePhrase;
import lotto.view.constant.ResultPhrase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    static final String PURCHASE_PHRASE = PurchasePhrase.PURCHASE.getPhrase();
    static final String LOTTERY_NUMBER_PHRASE = PurchasePhrase.LOTTERY_NUMBER.getPhrase();
    static final String RANK_PHRASE = ResultPhrase.RANK.getPhrase();
    static final String SECOND_RANK_PHRASE = ResultPhrase.SECOND_RANK.getPhrase();
    static final int TOTAL_PERCENT = 100;

    static DecimalFormat moneyFormat = new DecimalFormat(Format.MONEY.getFormat());

    public static void showPurchaseList(List<List<Integer>> lotteryTickets) {
        System.out.println(String.format(PURCHASE_PHRASE, lotteryTickets.size()));
        for (List<Integer> lotteryTicket : lotteryTickets) {
            showLotteryNumbers(lotteryTicket);
        }
    }

    private static void showLotteryNumbers (List<Integer> lotteryTicket) {
        List<Integer> lotteryNumbers = new ArrayList<>(lotteryTicket);
        Collections.sort(lotteryNumbers);
        System.out.println(String.format(LOTTERY_NUMBER_PHRASE, lotteryNumbers.toArray(new Integer[0])));
    }

    public static void showWinningResult (
            Map<LotteryRank, Integer> winningCountByRank,
            int numberOfAllTickets,
            long totalReward
    ) {
        System.out.println(ResultPhrase.TITLE.getPhrase());
        System.out.println(ResultPhrase.SEPARATE_LINE.getPhrase());
        showWinningCountByRank(winningCountByRank);
        showProfitRate(numberOfAllTickets, totalReward);
    }

    private static void showWinningCountByRank (Map<LotteryRank, Integer> winningCountByRank) {
        List<LotteryRank> winningRanks = LotteryRank.findWinningRankInAscendingOrder();
        for (LotteryRank rank : winningRanks) {
            System.out.println(createRankPhrase(rank, winningCountByRank.get(rank)));
        }
    }

    private static String createRankPhrase (LotteryRank rank, int numberOfTickets) {
        int numberOfMatches = rank.getNumberOfMatches();
        String reward = rank.getRewardInDecimalFormat(moneyFormat);
        if (rank == LotteryRank.SECOND) {
            return String.format(SECOND_RANK_PHRASE, numberOfMatches, reward, numberOfTickets);
        }
        return String.format(RANK_PHRASE, numberOfMatches, reward, numberOfTickets);
    }

    private static void showProfitRate (int numberOfAllTickets, long totalReward) {
        String profitRate = calculateProfitRate(numberOfAllTickets, totalReward);
        System.out.println(String.format(ResultPhrase.PROFIT_RATE.getPhrase(), profitRate));
    }

    private static String calculateProfitRate (int numberOfAllTickets, long totalReward) {
        int purchaseMoney = numberOfAllTickets * LottoProperty.PRICE.getProperty();
        double profitRate = (double) totalReward / purchaseMoney * TOTAL_PERCENT;
        return String.format(Format.PROFIT_RATE.getFormat(), profitRate);
    }
}
