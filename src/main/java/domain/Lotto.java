package domain;

import constant.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        if (isInCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_SIZE.getMessage());
        }
        if(isDuplicated(numbers, stream)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.getMessage());
        }
        if(isOverRange(stream)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OVERRANGE.getMessage());
        }
    }

    private boolean isInCorrectSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isOverRange(Stream<Integer> stream) {
        return stream.anyMatch(number -> number < 1 || number > 45);
    }

    private boolean isDuplicated(List<Integer> numbers, Stream<Integer> stream) {
        return stream.distinct().count() != numbers.size();
    }

    // TODO: 추가 기능 구현



}
