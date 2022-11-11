package lotto.model;

import java.util.List;

public class Lotto {

    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 6개이어야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지여야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> comparedNumbers = numbers.subList(i + 1, numbers.size());
            Integer number = numbers.get(i);
            if (comparedNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호 각각은 서로 중복될 수 없습니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}
