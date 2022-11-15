package lotto.domain;

import lotto.Lotto;
import lotto.input.Input;

import java.util.List;

public class LottoCalculator {
    private final Input input;
    private final List<Lotto> lottos;

    public LottoCalculator(Input input) {
        this.input = input;
        LottoGenerator lottoGenerator = new LottoGenerator(input.countingLotto());
        lottos = lottoGenerator.getLottos();
    }

    public void checkHit() {
        int correct;
        int bonusNumber = input.getBonusNumber();
        List<Integer> winningNumber = input.getWinningNumber();
        for (Lotto lotto : lottos) {
            correct = countCorrectNumber(lotto, winningNumber, bonusNumber);

        }
    }

    private void printWinningRecord(int correct) {
        if (correct == 3) {

        }
    }

    private int countCorrectNumber(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int correct = 0;
        for (int index = 0; index < 6; index++) {
            if (lotto.getNumbers().get(index).equals(winningNumber.get(index))) {
                correct++;
            }
        }

        if (correct == 5 && lotto.getNumbers().contains(bonusNumber)) {
            correct = 0;
        }

        return correct;
    }

}
