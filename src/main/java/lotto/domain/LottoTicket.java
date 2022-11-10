package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", getSortedNumbers());
    }

    private List<String> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
