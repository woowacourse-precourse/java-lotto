package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningHistory {
    private Map<Integer,Integer> winningHistory; //등수,integer

    public WinningHistory () {
        winningHistory = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            winningHistory.put(i, 0);
        }
    }

    public Map<Integer, Integer> getWinningHistory() {
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
            throw new IllegalArgumentException(Error.IS_NOT_UNIQUE.getMessage());
        }
    }

    private void saveWinningHistory(int count, int bonusNumber, Set<Integer> set) {
        if (count == 3) {
            winningHistory.put(5, winningHistory.get(5) + 1);
            return;
        }
        if (count == 4) {
            winningHistory.put(4, winningHistory.get(4) + 1);
            return;
        }
        if (count == 5) {
            if (set.contains(bonusNumber)) {
                winningHistory.put(2, winningHistory.get(2) + 1);
                return;
            }
            winningHistory.put(3, winningHistory.get(3) + 1);
            return;
        }
        if (count == 6) {
            winningHistory.put(1, winningHistory.get(1) + 1);
            return;
        }
    }


}
