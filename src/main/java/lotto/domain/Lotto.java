package lotto.domain;

import lotto.common.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> randomNumbers = LottoGenerator.createRandomLottoNumber();
        return new Lotto(randomNumbers);
    }

    public int findLottoWinCount(List<Integer> userLotto) {
        return (int) IntStream.range(0, Constant.LOTTO_SIZE)
                .filter(i -> userLotto.contains(numbers.get(i)))
                .count();
    }

    public int findBonusNumberWinCount(int bonusNumber) {
        return (int) IntStream.range(0, Constant.LOTTO_SIZE)
                .filter(i -> numbers.get(i).equals(bonusNumber))
                .count();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
