package lotto;

import java.util.List;
import lotto.system.SystemValid;
import lotto.type.ErrorType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        SystemValid.validateForSize(numbers, ErrorType.LOTTO);
        SystemValid.validateForBetween(numbers, ErrorType.LOTTO);
        SystemValid.validateForUnique(numbers, ErrorType.LOTTO);
    }

    public void printNumbers() {
        String print = "";

        for (int number : numbers) {
            print = print.concat(" " + number);
        }

        print = print.trim();
        print = print.replaceAll(" ", ", ");
        System.out.println("[" + print + "]");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
