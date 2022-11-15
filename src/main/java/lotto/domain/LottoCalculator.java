package lotto.domain;

import lotto.Lotto;
import lotto.input.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    private final Input input;
    private final List<Lotto> lottos;
    private Map<Integer, Integer> winningLotto;

    public LottoCalculator(Input input) {
        this.input = input;
        LottoGenerator lottoGenerator = new LottoGenerator(input.countingLotto());
        lottos = lottoGenerator.getLottos();
        winningLotto = initialWinningLotto();
    }

    public double calculateEarn() {
        double purchaseAmount = input.getPurchaseAmount();
        int total = 0;
        for (int key = 3; key <= 7; key++) {
            total += matchLotto(key, winningLotto.get(key));
        }
        double earn = total * 100.0 / purchaseAmount;
        return Math.round(earn * 10) / 10.0;
    }

    private int matchLotto(int key, int count) {
        if (key == 3) {
            return count * 5000;
        }
        if (key == 4) {
            return count * 50000;
        }
        if (key == 5) {
            return count * 1500000;
        }
        if (key == 6) {
            return count * 2000000000;
        }
        if (key == 7) {
            return count * 30000000;
        }
        return 0;
    }

    public void checkHit() {
        int correct;
        int bonusNumber = input.getBonusNumber();
        List<Integer> winningNumber = input.getWinningNumber();
        for (Lotto lotto : lottos) {
            correct = countCorrectNumber(lotto, winningNumber, bonusNumber);
            markUp(correct);
        }
    }

    private Map<Integer, Integer> initialWinningLotto() {
        Map<Integer, Integer> winningLotto = new HashMap<>();
        for (int key = 3; key <= 7; key++) {
            winningLotto.put(key, 0);
        }
        return winningLotto;
    }

    private void markUp(int correct) {
        if (correct == 3) {
            winningLotto.put(3, winningLotto.get(3) + 1);
            return;
        }
        if (correct == 4) {
            winningLotto.put(3, winningLotto.get(4) + 1);
            return;
        }
        if (correct == 5) {
            winningLotto.put(3, winningLotto.get(5) + 1);
            return;
        }
        if (correct == 6) {
            winningLotto.put(3, winningLotto.get(6) + 1);
            return;
        }
        if (correct == 7) {
            winningLotto.put(3, winningLotto.get(7) + 1);
        }
    }

    private int countCorrectNumber(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int correct = 0;
        for (Integer number : winningNumber) {
            if (lotto.getNumbers().contains(number)) {
                correct++;
            }
        }

        if (correct == 5 && lotto.getNumbers().contains(bonusNumber)) {
            correct = 7;
        }

        return correct;
    }

    public Map<Integer, Integer> getWinningLotto() {
        return winningLotto;
    }
}
