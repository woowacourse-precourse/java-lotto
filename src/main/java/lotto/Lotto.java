package lotto;

import java.util.ArrayList;
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
        List<Integer> duplication = new ArrayList<>();
        for (int number: numbers){
            if(duplication.contains(number)){
                throw new IllegalArgumentException("로또 번호에 중복되는 숫자가 있습니다");
            }
            if(!(number >= 1 && number <= 45)){
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            duplication.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
