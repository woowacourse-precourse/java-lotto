package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MAX = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumber(numbers);
        this.numbers = convertLottoNumber(numbers);
    }

    private void checkNumber(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
    }

    private List<LottoNumber> convertLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX) {
            throw new LottoInputException("[ERROR]");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다.");
        }
    }
}
