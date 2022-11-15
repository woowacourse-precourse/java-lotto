package lotto.domain.lotto;

import lotto.domain.lotto.util.Validate;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final String WARM = "[ERROR] ";
    private final String WARM_LOTTONUMBERS_SIZE = WARM + "로또번호는 6개이어야 합니다.";
    private final String WARM_NOT_ALLOW_OVERLAP_NUMBER = WARM + "중복된 수가 입력되었습니다.";
    private final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumberRange(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WARM_LOTTONUMBERS_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            Validate.validateLottoNumberRange(number);
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        HashSet<Integer> baseLottoNumbers = new HashSet<>(numbers);
        if (baseLottoNumbers.size() != numbers.size()) {
            System.out.println(WARM_NOT_ALLOW_OVERLAP_NUMBER);
            throw new IllegalArgumentException(WARM_NOT_ALLOW_OVERLAP_NUMBER);
        }
    }

}