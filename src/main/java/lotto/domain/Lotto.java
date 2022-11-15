package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 숫자 개수 확인 및 중복 확인
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_SIZE.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.ERROR_OVERLAP_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    // 해당 로또의 번호 가져오기
    public List<Integer> getNumbers() {
        return numbers;
    }


}
