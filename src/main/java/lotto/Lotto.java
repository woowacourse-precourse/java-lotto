package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicatedCheck(numbers);
        rangeCheck(numbers);
    }

    public void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicatedCheck(List<Integer> numbers) {
        for (int i=0; i<numbers.size(); i++) {
            if (numbers.indexOf(numbers.get(i)) != -1 && numbers.indexOf(numbers.get(i)) != i) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void rangeCheck(List<Integer> numbers) {
        for (int i=0; i<numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNumbers() {
        String result = "[";
        for (int idx = 0; idx < this.numbers.size(); idx++) {
            result += this.numbers.get(idx);
            if (idx != this.numbers.size()-1) {
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }
}
