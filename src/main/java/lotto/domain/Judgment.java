package lotto.domain;

import java.util.List;

public class Judgment {
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
