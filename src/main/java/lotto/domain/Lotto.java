package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    public static Lotto generateLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> removeDuplicateNumber = new HashSet<>(numbers);
        if (removeDuplicateNumber.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자이어야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
