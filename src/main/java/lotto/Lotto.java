package lotto;

import java.util.List;

import static lotto.utils.Messages.ERROR_DUPLICATION_MESSAGE;
import static lotto.utils.Messages.ERROR_LENGTH_MESSAGE;
import static lotto.utils.Messages.ERROR_RANGE_MESSAGE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }


    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ERROR_LENGTH_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers){

            if(number<1 || number >45){
                System.out.println(ERROR_RANGE_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long removedDuplicateSize = numbers.stream()
                .distinct().count();

        if (numbers.size() != removedDuplicateSize) {
            System.out.println(ERROR_DUPLICATION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
