package lotto;

import io.Output;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

    public void indexedForEach(Consumer<Integer> consumer) {
        for (Integer number : numbers) {
            consumer.accept(number);
        }
    }

    public void printLottoDigits(Output output) {
        //System.out.println(numbers);
        output.printOutput(numbers.toString());

    }
    // TODO: 추가 기능 구현
}
