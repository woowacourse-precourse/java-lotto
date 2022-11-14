package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0 ; i < numbers.size()-1 ; i++){
            builder.append(numbers.get(i));
            builder.append(", ");
        }
        builder.append(numbers.get(5));
        builder.append("]");
        return builder.toString();
    }



}
