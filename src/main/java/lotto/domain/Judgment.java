package lotto.domain;

import lotto.domain.enums.WinningAmount;

import java.util.List;

public class Judgment {
    private static final int PRINT_START_INDEX = 3;

    public int calculatePrizeMoney(int[] wins) {
        WinningAmount[] values = WinningAmount.values();
        int totalMoney = 0;

        for (int i = 0; i < values.length; i++) {
            totalMoney += values[i].getPrizeMoney() * wins[i + PRINT_START_INDEX];
        }

        return totalMoney;
    }

    public int[] calculateWins(List<Lotto> myLottos, List<Integer> winningNumber) {
        int[] wins = new int[Lotto.numberCount + 1];
        for (int i = 0; i < myLottos.size(); i++) {
            List<Integer> lottoNumber = myLottos.get(i).getNumbers();
            int winCount = compareToNumber(lottoNumber, winningNumber);
            wins[winCount]++;
        }
        return wins;
    }

    public int compareToNumber(List<Integer> myNumber, List<Integer> winningNumber) {
        int winCount = 0;
        for (int i : myNumber) {
            if (winningNumber.contains(i)) {
                winCount++;
            }
        }
        return winCount;
    }

    public boolean compareToBonus(List<Integer> myNumber, int bonusNumber) {
        return myNumber.contains(bonusNumber);
    }
}
