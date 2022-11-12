package lotto.domain;

import java.util.List;

public class RandomLotto {

    private List<List<Integer>> randomLottoNumbersList;
    private int numberOfLottoGame;

    public RandomLotto(int numberOfLottoGame) {
        this.numberOfLottoGame = numberOfLottoGame;
    }
//
//    public void makeRandomLottoNumbers(int numberOfLottoGame) {
//        for (int i = 0; i < numberOfLottoGame; i++) {
//
//        }
//    }

    public List<List<Integer>> getRandomLottoNumbersList() {
        return randomLottoNumbersList;
    }

    public int getNumberOfLottoGame() {
        return numberOfLottoGame;
    }
}
