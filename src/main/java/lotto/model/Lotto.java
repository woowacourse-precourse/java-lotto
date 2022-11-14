package lotto.model;

import lotto.Constant;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumRange(numbers);
        validateNumOverlap(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.lottoNumSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= Constant.lottoRangeStartNum && number <= Constant.lottoRangeEndNum)) {
                System.out.println(Constant.errorNumberRange);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumOverlap(List<Integer> numbers) {
        Set<Integer> numberCollect = numbers.stream().collect(Collectors.toSet());
        if (numbers.size() != numberCollect.size()) {
            System.out.println(Constant.errorNumberOverlapped);
            throw new IllegalArgumentException();
        }
    }

}
