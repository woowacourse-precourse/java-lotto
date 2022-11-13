package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private final List<List<Integer>> randomLottoNumbers = new ArrayList<>();
    private final int numberOfLottoGame;

    public RandomLotto(int numberOfLottoGame) {
        this.numberOfLottoGame = numberOfLottoGame;
    }

    public List<List<Integer>> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }

    public int getNumberOfLottoGame() {
        return numberOfLottoGame;
    }
}
