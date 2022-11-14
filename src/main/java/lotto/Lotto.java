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
            throw new IllegalArgumentException("[ERROR]: 로또의 사이즈는 6이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        String output = "";
        for (int number : numbers) {
            output += String.valueOf(number);
            output += ", ";
        }
        output = output.substring(0, output.length() - 2); // ", ".length() == 2 마지막 ", " 제거
        return "[" + output + "]";
    }
}
