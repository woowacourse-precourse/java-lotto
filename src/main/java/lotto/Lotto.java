package lotto;

import static lotto.Constant.LottoValue.MAX_RANGE;
import static lotto.Constant.LottoValue.MIN_RANGE;
import static lotto.Constant.LottoValue.NUMBER_EA;

import static lotto.Util.LottoNumberValidator.*;

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




    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
