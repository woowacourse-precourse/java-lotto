package lotto;

import io.Output;
import java.util.List;
import java.util.function.BiConsumer;

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

    public void indexedForEach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < numbers.size(); i++) {
            consumer.accept(numbers.get(i), i);
        }
    }

    public void printLottoDigits(Output output) {
        //System.out.println(numbers);
        output.printOutput(numbers.toString());

    }
    // TODO: 추가 기능 구현
}
