package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAndWinningNumber {
    public List<Integer> comparison(List<List<Integer>> randomLotto, Lotto answer) {
        List<Integer> winningNumbers = answer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> random : randomLotto) {
            int countLotto = 0;

            for (int numberLocation = 0; numberLocation < winningNumbers.size(); numberLocation++) {
                int correctLotto = winningNumbers.get(numberLocation);
                countLotto = checkConfirmation(random, countLotto, correctLotto);
            }
            result.add(countLotto);
        }
        return result;
    }

    public int checkConfirmation(List<Integer> random, int countLotto, int correctLotto) {
        for (int randomLocation = 0; randomLocation < random.size(); randomLocation++) {
            if (correctLotto == random.get(randomLocation)) {
                countLotto++;
            }
        }
        return countLotto;
    }
}
