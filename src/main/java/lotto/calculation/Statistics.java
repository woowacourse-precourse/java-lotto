package lotto.calculation;

import lotto.exception.IllegalArgument;
import lotto.generation.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    public long getRevenue(List<Rank> rankCount) {
        long revenue = 0L;
        for (Rank rank : Rank.values()) {
            revenue += rank.getReward() * Collections.frequency(rankCount, rank);
        }
        return revenue;
    }

    public List<Rank> getRankCount(List<List<Integer>> totalWinningCount) {
        List<Rank> rankCount = new ArrayList<>();
        for (List<Integer> count : totalWinningCount) {
            if (count.get(0) >= 3) {
                rankCount.add(getRankFromCount(count));
            }
        }
        return rankCount;
    }

    public Rank getRankFromCount(List<Integer> count) {
        if (count.get(0) == 3) {
            return Rank.RANK_FIVE;
        }
        if (count.get(0) == 4) {
            return Rank.RANK_FOUR;
        }
        if (count.get(0) == 5 && count.get(1) == 0) {
            return Rank.RANK_THREE;
        }
        if (count.get(0) == 5 && count.get(1) == 1) {
            return Rank.RANK_TWO;
        }
        return Rank.RANK_ONE;
    }

    public List<List<Integer>> getTotalWinningCount(List<Lotto> lottos, Winning winning) {
        List<List<Integer>> totalWinningCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            totalWinningCount.add(getWinningCount(lotto.getNumbers(), winning));
        }
        return totalWinningCount;
    }

    public List<Integer> getWinningCount(List<Integer> numbers, Winning winning) {
        List<Integer> winningCount = new ArrayList<>();
        int count = 0;
        for (int winningNumber : winning.getWinningNumbers()) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        winningCount.add(count);
        if (count == 5 && matchBonusNumber(getLottoBonusNumber(numbers), winning)) {
            winningCount.add(1);
            return winningCount;
        }
        winningCount.add(0);
        return winningCount;
    }

    public int getLottoBonusNumber(List<Integer> numbers) {
        int bonusNumber = 0;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (!IllegalArgument.isRedundancyWithNumbers(bonusNumber, numbers));
        return bonusNumber;
    }

    public boolean matchBonusNumber(int bonusNumber, Winning winning) {
        if (bonusNumber == winning.getBonusNumber()) {
            return true;
        }
        return false;
    }
}
