package model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateInputLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    // 입력되는 당첨번호에 중복값이 있는 경우 유효성 검사
    private void validateDuplicateInputLottoNumbers(List<Integer> numbers) {
        int lottoNumbersCount = getLottoNumbersSet(numbers).size();

        if (lottoNumbersCount != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되지 않게 입력해주세요.");
        }
    }

    // 당첨번호를 Set 으로 반환
    private HashSet<Integer> getLottoNumbersSet(List<Integer> numbers) {
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);

        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
