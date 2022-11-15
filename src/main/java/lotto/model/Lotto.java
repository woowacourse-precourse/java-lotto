package lotto.model;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.vallidator.LottoValidator;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validate(numbers);
    }

    public static List<Lotto> buyLottos(int money) {
        int amount = money / Constants.LOTTO_PRICE;
        return IntStream.range(0, amount)
                .mapToObj(index -> Lotto.generate())
                .collect(Collectors.toList());
    }

    private static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_LENGTH));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
