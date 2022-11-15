package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLength(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Constants.ERROR_LENGTH);
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        List<Integer> duplicateCheck = numbers.stream().distinct().collect(Collectors.toList());
        try {
            if (duplicateCheck.size() != numbers.size()) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Constants.ERROR_DUPLICATE);
        }
    }
}