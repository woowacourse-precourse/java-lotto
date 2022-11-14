package Character;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

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
            System.out.println("[ERROR] 입력 숫자의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicatedNumberValidate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (!(numbers.size()==noDuplicateNumbers.size())) {
            System.out.println("[ERROR] 중복된 숫자가 존재해서는 안 됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidate (List<Integer> numbers) {
        for (int value : numbers) {
            if (value<1||value>45) {
                System.out.println("[ERROR] 숫자의 범위는 1 이상 45 이하여야 합니다.");
                throw new IllegalArgumentException();
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
