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

    // TODO: 추가 기능 구현
    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int buyCount = 0; buyCount < count; buyCount++) {
            Lotto lotto =
                    new Lotto(Lotto.createLottoNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList()));
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
