package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicate(numbers);
        notInclude(numbers);
    }

    private void sizeCheck(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수를 6개여야합니다.");
        }
    }

    private void duplicate(List<Integer> numbers){
        Set<Integer> numbersCheck = new HashSet<>(numbers);

        if (numbersCheck.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복 숫자가 있으면 안됩니다.");
        }
    }

    private void notInclude(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다.");
            }
        }
    }
}
