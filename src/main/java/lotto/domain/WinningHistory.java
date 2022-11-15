package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.domain.WinningMoney.*;

public class WinningHistory {
    private Map<WinningMoney,Integer> winningHistory;
    private double yield;

    public WinningHistory () {
        winningHistory = new HashMap<>();
        winningHistory.put(FIVE_THOUSAND, 0);
        winningHistory.put(FIFTY_THOUSAND, 0);
        winningHistory.put(ONE_MILLION_AND_A_HALF_MILLION, 0);
        winningHistory.put(THIRTY_MILLION, 0);
        winningHistory.put(TWO_BILLION, 0);

    }

    public Map<WinningMoney, Integer> getWinningHistory() {
        return winningHistory;
    }

    public void compareLotto(Lotto winningNumber, int bonusNumber, List<Lotto> lottos) {
        validateUnique(bonusNumber, winningNumber);
        for (Lotto lotto : lottos) {
            int count = 0;
            Set<Integer> set = lotto.getNumbers(); //발행로또
            count = (int) winningNumber.getNumbers().stream().filter(a -> set.contains(a)).count();
            saveWinningHistory(count, bonusNumber, set);
        }
    }

    private void validateUnique(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.UNIQUE_NUMBER.getMessage());
        }
    }

    private void saveWinningHistory(int count, int bonusNumber, Set<Integer> set) {
        if (count == 3) {
            winningHistory.put(FIVE_THOUSAND, winningHistory.get(FIVE_THOUSAND) + 1);
            return;
        }
        if (count == 4) {
            winningHistory.put(FIFTY_THOUSAND, winningHistory.get(FIFTY_THOUSAND) + 1);
            return;
        }
        if (count == 5) {
            if (set.contains(bonusNumber)) {
                winningHistory.put(THIRTY_MILLION, winningHistory.get(THIRTY_MILLION) + 1);
                return;
            }
            winningHistory.put(ONE_MILLION_AND_A_HALF_MILLION, winningHistory.get(ONE_MILLION_AND_A_HALF_MILLION) + 1);
            return;
        }
        if (count == 6) {
            winningHistory.put(TWO_BILLION, winningHistory.get(TWO_BILLION) + 1);
            return;
        }
    }


    public void calculateYield(int money) {
        long sum = 0L;
        for (WinningMoney winningMoney : winningHistory.keySet()) {
            if (winningHistory.get(winningMoney) > 0) {
                sum += winningHistory.get(winningMoney) * winningMoney.getWinningMoney();
            }
        }
        yield = Math.round((double) sum / money * 1000) / 10.0;
    }

    public double getYield() {
        return yield;
    }
}
