package lotto.Object;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Exception.Exception;

public class Lotto {
    private final List<Integer> numbers;
    Exception exception = new Exception();

    public String getNumbersToString() {
        return numbers.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        numberSizeValidate(numbers);
        duplicatedNumberValidate(numbers);
        numberRangeValidate(numbers);
        this.numbers = numbers;
    }

    private void numberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exception.throwInvalidSizeException();
        }
    }

    private void duplicatedNumberValidate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (!(numbers.size()==noDuplicateNumbers.size())) {
            exception.throwInvalidInputException();
        }
    }

    private void numberRangeValidate (List<Integer> numbers) {
        for (int value : numbers) {
            if (value<1||value>45) {
                exception.throwInvalidNumberRangeException();
            }
        }
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public boolean contains(int inputNumber) {
        return numbers.contains(inputNumber);
    }
}
