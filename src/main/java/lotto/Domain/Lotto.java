package lotto.Domain;

import Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> setLottos(int lottoCount) {
        List<List<Integer>> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(RandomUtils.getRandomLottoNumber());
        }
        return lottos;
    }
}
