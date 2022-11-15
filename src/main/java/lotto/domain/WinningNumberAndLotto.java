package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberAndLotto {

    public List<Integer> comparison(List<List<Integer>> randomLotto, Lotto answer) {
        List<Integer> winningNumbers = answer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> random : randomLotto) {
            int countLotto = 0;

            for (int correctLotto : winningNumbers) {
                countLotto = judgement(random, countLotto, correctLotto);
            }
            result.add(countLotto);
        }
        return result;
    }

    public int judgement(List<Integer> random, int countLotto, int correctLotto) {
        for (Integer integer : random) {
            if (correctLotto == integer) {
                countLotto++;
            }
        }
        return countLotto;
    }
}
