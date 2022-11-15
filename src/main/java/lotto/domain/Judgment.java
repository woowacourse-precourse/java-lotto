package lotto.domain;

import lotto.domain.enums.WinningAmount;

import java.util.List;

public class Judgment {
    private static final int WIN_RANK_AMOUNT = 5;
    private static final int PRINT_START_INDEX = 3;

    static public int calculatePrizeMoney(int[] wins) {
        WinningAmount[] values = WinningAmount.values();
        int totalMoney = 0;

        for (int i = 0; i < values.length; i++) {
            totalMoney += values[i].getPrizeMoney() * wins[i];
        }

        return totalMoney;
    }

    static public int[] calculateWins(List<Lotto> myLottos, List<Integer> winningNumber, int bonus) {
        int[] wins = new int[WIN_RANK_AMOUNT];

        for (int i = 0; i < myLottos.size(); i++) {
            List<Integer> lottoNumber = myLottos.get(i).getNumbers();
            int winRank = calculateRank(lottoNumber, winningNumber, bonus);
            if (winRank >= 0) {
                wins[winRank]++;
            }
        }
        return wins;
    }

    static public int calculateRank(List<Integer> myNumber, List<Integer> winningNumber, int bonusNumber) {
        int winCount = compareToNumber(myNumber, winningNumber);

        if (winCount < 5 || winCount == 5 && !compareToBonus(myNumber, bonusNumber)) {
            return winCount - PRINT_START_INDEX;
        }
        if (winCount == 6) {
            return 4;
        }

        return 2;
    }

    static public int compareToNumber(List<Integer> myNumber, List<Integer> winningNumber) {
        int winCount = 0;

        for (int i : myNumber) {
            if (winningNumber.contains(i)) {
                winCount++;
            }
        }

        return winCount;
    }

    static public boolean compareToBonus(List<Integer> myNumber, int bonusNumber) {
        return myNumber.contains(bonusNumber);
    }
}
