package lotto.domain;

import java.util.List;

public class RandomLottoNumber {
    private List<Integer> randomNumber;
    public Winner winner;

    public RandomLottoNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Integer> getRandomNum() {
        return randomNumber;
    }

}
