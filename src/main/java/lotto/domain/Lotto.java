package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!isInBound(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 잘못되었습니다.");
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> ascending(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>(numbers);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }


    private boolean isInBound(List<Integer> numbers) {
        return numbers.size() == Config.LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != Config.LOTTO_NUMBER_COUNT;
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return Objects.equals(this.toString(), lotto.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}
