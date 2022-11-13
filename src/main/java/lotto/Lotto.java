package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        Lotto that = (Lotto) o;
        Set<Integer> s1 = new HashSet<>(this.numbers);
        Set<Integer> s2 = new HashSet<>(that.numbers);
        return s1.equals(s2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(numbers));
    }

    @Override
    public String toString() {
        String collect = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + collect + "]";
    }
}
