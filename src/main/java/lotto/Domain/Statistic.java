package lotto.Domain;

import java.util.HashMap;

import static lotto.Enum.LottoProperty.HIGHEST_WINNING_RANK;
import static lotto.Enum.LottoProperty.LOWEST_WINNING_RANK;
import static lotto.Enum.StatisticMessage.*;

public class Statistic extends LottoShop {
    private HashMap<Integer, Integer> RankDistributionMap;
    private long accumulatedWinning = 0;

    private int lowestRank = LOWEST_WINNING_RANK.getValue();
    private int highestRank = HIGHEST_WINNING_RANK.getValue();

    public void ShowStatistic() {
        RankDistributionMap = new HashMap<>();
        calculateRank();
        showRankResult();
        showYield();
    }

    private void calculateRank() {
        for (int rank = lowestRank; rank <= highestRank; rank++) {
            searchRankByNumber(rank);
        }
    }

    private void searchRankByNumber(int rank) {
        // TODO: 당첨번호와 모든 구입번호를 비교하여 등수 별로 맵에 담는다.
    }

    private void showRankResult() {
        for (int rank = highestRank; rank >= lowestRank; rank--) {
            int count = RankDistributionMap.get(rank);
            String message = getMessage(rank, count);

            System.out.println(message);
        }
    }

    private String getMessage(int rank, int count) {
        String message;

        if (rank == 5) {
            message = WINNING_5RANK.getMessage(count);
        } else if (rank == 4) {
            message = WINNING_4RANK.getMessage(count);
        } else if (rank == 3) {
            message = WINNING_3RANK.getMessage(count);
        } else if (rank == 2) {
            message = WINNING_2RANK.getMessage(count);
        } else {
            message = WINNING_1RANK.getMessage(count);
        }

        return message;
    }

    public void showYield() {

    }
}
