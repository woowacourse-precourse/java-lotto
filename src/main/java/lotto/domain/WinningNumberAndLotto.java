package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.subaction.WinningNumberPlace;

public class WinningNumberAndLotto {
    private final WinningNumberPlace winningNumberPlace;

    public WinningNumberAndLotto(WinningNumberPlace winningNumberPlace) {
        this.winningNumberPlace = winningNumberPlace;
    }

    public List<Integer> comparison(List<List<Integer>> randomLotto, Lotto answer) {
        List<Integer> winningNumbers = answer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> random : randomLotto) {
            int countLotto = 0;

            for (int numberLocation = 0; numberLocation < winningNumbers.size(); numberLocation++) {
                int correctLotto = winningNumbers.get(numberLocation);
                countLotto = winningNumberPlace.judgement(random, countLotto, correctLotto);
            }
            result.add(countLotto);
        }
        return result;
    }
}
