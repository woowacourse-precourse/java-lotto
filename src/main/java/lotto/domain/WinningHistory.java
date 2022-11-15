package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.domain.Error.*;
import static lotto.domain.Number.*;
import static lotto.domain.WinningMoney.*;

public class WinningHistory {
    private static final double TEN = 10.0;
    private static final long ZERO_L = 0L;
    private Map<WinningMoney, Integer> winningHistory;
    private double yield;

    public WinningHistory() {
        winningHistory = new HashMap<>();
        winningHistory.put(FIVE_THOUSAND, ZERO.getNumber());
        winningHistory.put(FIFTY_THOUSAND, ZERO.getNumber());
        winningHistory.put(ONE_MILLION_AND_A_HALF_MILLION, ZERO.getNumber());
        winningHistory.put(THIRTY_MILLION, ZERO.getNumber());
        winningHistory.put(TWO_BILLION, ZERO.getNumber());

    }

    public Map<WinningMoney, Integer> getWinningHistory() {
        return winningHistory;
    }

    public void compareLotto(Lotto winningNumber, int bonusNumber, List<Lotto> lottos) {
        validateUnique(bonusNumber, winningNumber);
        for (Lotto lotto : lottos) {
            Set<Integer> numbers = lotto.getNumbers();
            int count = (int) winningNumber.getNumbers().stream().filter(number -> numbers.contains(number)).count();
            saveWinningHistory(count, bonusNumber, numbers);
        }
    }

    private void validateUnique(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(UNIQUE_NUMBER.getMessage());
        }
    }

    private void saveWinningHistory(int count, int bonusNumber, Set<Integer> numbers) {
        saveFifthPlace(count);
        saveFourthPlace(count);
        saveThirdPlace(count, bonusNumber, numbers);
        saveFirstPlace(count);
    }

    private void saveThirdPlace(int count, int bonusNumber, Set<Integer> numbers) {
        if (count == FIVE.getNumber()) {
            if (saveSecondPlace(bonusNumber, numbers)) {
                return;
            }
            winningHistory.put(ONE_MILLION_AND_A_HALF_MILLION,
                    winningHistory.get(ONE_MILLION_AND_A_HALF_MILLION) + ONE.getNumber());
        }
    }

    private boolean saveSecondPlace(int bonusNumber, Set<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            winningHistory.put(THIRTY_MILLION, winningHistory.get(THIRTY_MILLION) + ONE.getNumber());
            return true;
        }
        return false;
    }

    private void saveFirstPlace(int count) {
        if (count == SIX.getNumber()) {
            winningHistory.put(TWO_BILLION, winningHistory.get(TWO_BILLION) + ONE.getNumber());
        }
    }

    private void saveFourthPlace(int count) {
        if (count == FOUR.getNumber()) {
            winningHistory.put(FIFTY_THOUSAND, winningHistory.get(FIFTY_THOUSAND) + ONE.getNumber());
        }
    }

    private void saveFifthPlace(int count) {
        if (count == THREE.getNumber()) {
            winningHistory.put(FIVE_THOUSAND, winningHistory.get(FIVE_THOUSAND) + ONE.getNumber());
        }
    }

    public void calculateYield(int money) {
        long sum = ZERO_L;
        for (WinningMoney winningMoney : winningHistory.keySet()) {
            if (winningHistory.get(winningMoney) > ZERO.getNumber()) {
                sum += winningHistory.get(winningMoney) * winningMoney.getWinningMoney();
            }
        }
        yield = Math.round((double) sum / money * THOUSAND.getNumber()) / TEN;
    }

    public double getYield() {
        return yield;
    }
}
