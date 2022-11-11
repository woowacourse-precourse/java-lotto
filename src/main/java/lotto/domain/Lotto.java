package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.dto.LottosResponseDto.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidationUtils.validate(numbers);
        this.numbers = numbers;
    }

    public int countContainsNumber(Lotto lotto) {
        return (int) numbers.stream()
                .mapToInt(number -> number)
                .filter(lotto::isContains)
                .count();
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    public LottoResponseDto toResponseDto() {
        sort();
        return new LottoResponseDto(new ArrayList<>(numbers));
    }

    private void sort() {
        Collections.sort(numbers);
    }
}
