package lotto.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.Enum.LottoProperty.*;

public class Statistic extends LottoShop {
    private int lowestRank;
    private int highestRank;

    private HashMap<Integer, Integer> RankDistributionMap;
    private HashMap<Integer, Integer> winningMoneyPerRank;
    public long accumulatedWinningMoney;

    public Statistic() {
        lowestRank = LOWEST_WINNING_RANK.getValue();
        highestRank = HIGHEST_WINNING_RANK.getValue();

        this.RankDistributionMap = new HashMap<>();
        this.winningMoneyPerRank = new HashMap<>();

        List<Integer> winningMoneyList = List.of(
                RANK1_WINNING_MONEY.getValue(),
                RANK2_WINNING_MONEY.getValue(),
                RANK3_WINNING_MONEY.getValue(),
                RANK4_WINNING_MONEY.getValue(),
                RANK5_WINNING_MONEY.getValue()
        );

        for (int rank = lowestRank; rank >= highestRank; rank--) {
            this.RankDistributionMap.put(rank, 0);

            int winningMoney = winningMoneyList.get(rank - 1);
            this.winningMoneyPerRank.put(rank, winningMoney);
        }

        this.accumulatedWinningMoney = 0;
    }

    public void analyze() {
        for (List<Integer> soldNumberList : soldLottoList) {
            List<Integer> matchedNumberList = removeUnmatchedNumbers(soldNumberList);

            int rank = inspection.getRankByMatchNumberList(matchedNumberList, bonusNumber);

            if(rank == 0){
                continue;
            }

            int rankCount = RankDistributionMap.get(rank);
            rankCount++;
            RankDistributionMap.put(rank, rankCount);

            accumulatedWinningMoney += winningMoneyPerRank.get(rank);
        }
    }

    private List<Integer> removeUnmatchedNumbers(List<Integer> soldNumberList) {
        List<Integer> removedList = new ArrayList<>();

        for (int checkNumber : soldNumberList) {
            if (winningNumbers.contains(checkNumber)) {
                removedList.add(checkNumber);
            }
        }

        return removedList;
    }

    public int getRankCount(int rank) {
        return RankDistributionMap.get(rank);
    }

}
