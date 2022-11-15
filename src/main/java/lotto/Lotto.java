package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ErrorUtil;

import static lotto.constant.Constant.*;

import java.util.List;
import java.util.stream.Collectors;


public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSize_6(numbers);
        isNotDuplicated(numbers);
        isInRange(numbers);
    }

    private void isSize_6(List<Integer> numbers) {
        if (numbers.size() != lotto_length) {
            ErrorUtil.throwError(ERROR_MESSAGE+ERROR_SIZE);
        }
    }

    private void isNotDuplicated(List<Integer> numbers) {
        int notDuplicatedSize = (int) numbers.stream().distinct().count();
        if (notDuplicatedSize != lotto_length) {
            ErrorUtil.throwError(ERROR_MESSAGE+ERROR_DUPLICATE);
        }
    }

    private void isInRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < lotto_min || n > lotto_max ) {
                ErrorUtil.throwError(ERROR_MESSAGE+ERROR_BOUNDARY);
            }
        }
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public static List<Integer> createRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lotto_min, lotto_max, lotto_length);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

}
