package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private List<List<Integer>> randomLottoNumbersList = new ArrayList<>();
    private int numberOfLottoGame;

    public RandomLotto(int numberOfLottoGame) {
        this.numberOfLottoGame = numberOfLottoGame;
    }

    public List<List<Integer>> getRandomLottoNumbersList() {
        return randomLottoNumbersList;
    }

    public int getNumberOfLottoGame() {
        return numberOfLottoGame;
    }
}
