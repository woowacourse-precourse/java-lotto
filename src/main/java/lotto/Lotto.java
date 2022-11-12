package lotto;

import static lotto.Constant.LottoValue.MAX_RANGE;
import static lotto.Constant.LottoValue.MIN_RANGE;
import static lotto.Constant.LottoValue.NUMBER_EA;

import static lotto.LottoNumberValidator.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;



public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        try {
            validateNumbers(numbers);
        } catch (Exception exception) {
            throw exception;
        }
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_EA);
        final Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
