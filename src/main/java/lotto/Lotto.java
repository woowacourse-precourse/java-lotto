package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input) {
        List<String> splitedInput = Arrays.asList(input.split(","));

        if(InputValidator.isInvalidSeparator(splitedInput)) {
            throw new IllegalArgumentException();
        }

        this.numbers = splitedInput.stream()
                .map(eachInput -> Integer.parseInt(eachInput))
                .sorted()
                .collect((Collectors.toList()));
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.existDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
