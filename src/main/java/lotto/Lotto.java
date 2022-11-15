package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<List<Integer>> makeLotto(int count) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < count; i ++){
            List<Integer> winLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            winLotto = winLotto.stream().sorted().collect(Collectors.toList());
            lottos.add(winLotto);
        }

        return lottos;
    }
}
