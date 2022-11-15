package lotto.domain;

import java.util.List;

public class RandomLotto {

    private final List<List<Integer>> randomLottos;
    private final int numberOfLottoGame;

    public RandomLotto(List<List<Integer>> randomLottos, int numberOfLottoGame) {
        validateRandomLotto(randomLottos, numberOfLottoGame);
        this.randomLottos = randomLottos;
        this.numberOfLottoGame = numberOfLottoGame;
    }

    private void validateRandomLotto(List<List<Integer>> randomLottos, int numberOfLottoGame) {
        if (numberOfLottoGame < 1) {
            throw new IllegalArgumentException();
        }
        if (randomLottos.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (randomLottos.size() != numberOfLottoGame) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> getRandomLottos() {
        return randomLottos;
    }

    public int getNumberOfLottoGame() {
        return numberOfLottoGame;
    }
}
