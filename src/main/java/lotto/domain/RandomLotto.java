package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private final List<List<Integer>> randomLottos;
    private final int numberOfLottoGame;

    public RandomLotto(List<List<Integer>> randomLottos, int numberOfLottoGame) {
        this.randomLottos = randomLottos;
        this.numberOfLottoGame = numberOfLottoGame;
    }

    public List<List<Integer>> getRandomLottos() {
        return randomLottos;
    }

    public int getNumberOfLottoGame() {
        return numberOfLottoGame;
    }
}
