package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    public static final String LOTTO_UNIT = "개";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder lottoNumbers = new StringBuilder();
        lottoNumbers.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            lottoNumbers.append(numbers.get(i).toString());
            if (i != numbers.size() - 1) {
                lottoNumbers.append(", ");
            }
        }
        lottoNumbers.append("]");
        return lottoNumbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(List<Integer> winningSixNumbers) {
        Set<Integer> common = numbers.stream().filter(winningSixNumbers::contains)
                .collect(Collectors.toSet());
        return common.size();
    }
}
