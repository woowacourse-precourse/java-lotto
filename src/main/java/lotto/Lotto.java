package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.numberCountValidation(numbers);
        Validation.numberRangeValidation(numbers);
        Validation.numberDuplicateValidation(numbers);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("[");
        for(int i = 0;i < numbers.size();i++) {
            result.append(numbers.get(i));
            if(i <= numbers.size() - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }


}
