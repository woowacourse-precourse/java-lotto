package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private static final int NUMBERS_LENGTH = 6;
    private static final String NUMBERS_LENGTH_EXCEPTION_MESSAGE =
            "로또 번호는 중복을 제외한 " + NUMBERS_LENGTH + "개입니다.";

    private final Set<LottoNumber> numbers;

    public Lotto(Integer... numbers) {
        this(Set.of(numbers));
    }

    public Lotto(List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(Set<Integer> numbers) {
        validateLength(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Lotto createRandomized() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.RANGE_MINIMUM, LottoNumber.RANGE_MAXIMUM,
                NUMBERS_LENGTH));
    }

    private void validateLength(Set<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NUMBERS_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public int countMatchesWith(Lotto other) {
        return Math.toIntExact(numbers.stream()
                .filter(other::contains)
                .count());
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toUnmodifiableList());
    }
}
