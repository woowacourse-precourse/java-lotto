package lotto.domain;


import java.util.List;
import java.util.stream.Collectors;
import lotto.shell.Exception;

public class Lotto  {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            new Exception().sizeException();
        }
    }

    // 리스트로 형 변환
    public List<Integer> typeToList() {
        return numbers.stream()
                .collect(Collectors.toList());
    }



}
