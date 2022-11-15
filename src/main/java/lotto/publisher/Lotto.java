package lotto.publisher;

import java.util.List;
import java.util.stream.Collectors;
import lotto.filter.Filter;
import lotto.filter.LottoDuplicationFilter;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        filters(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void filters(List<Integer> numbers) {
        String number = numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(","));

        Filter filter = new LottoDuplicationFilter();

        filter.doFilter(number);
    }
}
