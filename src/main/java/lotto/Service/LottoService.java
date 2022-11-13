package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.ValidNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();

    public Lotto createRandomLotto() {
        List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, MAX_LOTTO_SIZE);

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public Lotto createCustomLotto(String input) {
        List<Integer> numbers = Stream.of(input.split("\\s*,\\s*"))
                .map(n -> (Integer.parseInt(n)))
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

}
