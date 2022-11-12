package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LottoComparator {

    // (index + 1)등 개수 리스트
    private final List<Integer> calculateResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public LottoComparator(Set<Lotto> lotteries, Lotto winningLotto, int bonusNumber) {
        calculateResult(lotteries, winningLotto, bonusNumber);
    }

    private void calculateResult(Set<Lotto> lotteries, Lotto winningLotto, int bonusNumber) {
        for (Lotto lottery : lotteries) {
            int containCount = getContainCount(lottery, winningLotto);
            boolean bonus = isBonus(lottery, winningLotto, bonusNumber);
            setCalculateResult(containCount, bonus);
        }
    }

    private int getContainCount(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.getLottoNumbers().contains(winningLotto.getLottoNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonus(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (!lotto.getLottoNumbers().get(i).equals(winningLotto.getLottoNumbers().get(i))) {
                return lotto.getLottoNumbers().get(i) == bonusNumber;
            }
        }
        return false;
    }

    private void setCalculateResult(int containCount, boolean bonus) {
        if (containCount == 6) { // 1등
            calculateResult.set(0, calculateResult.get(0) + 1);
        }
        if (containCount == 5 && bonus) { // 2등
            calculateResult.set(1, calculateResult.get(1) + 1);
        }
        if (containCount == 5 && !bonus) { // 3등
            calculateResult.set(2, calculateResult.get(2) + 1);
        }
        if (containCount == 4) { // 4등
            calculateResult.set(3, calculateResult.get(3) + 1);
        }
        if (containCount == 3) { // 5등
            calculateResult.set(4, calculateResult.get(4) + 1);
        }
    }

    public List<Integer> getCalculateResult() {
        return calculateResult;
    }
}
