package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDupli(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDupli(List<Integer> numbers) {
        for(int i=0; i<numbers.size()-1; i++) {
            if(numbers.get(i)==numbers.get(i+1)) {
                System.out.println("[ERROR] 로또 숫자가 중복됩니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i)<1 || numbers.get(i)>45) {
                System.out.println("[ERROR] 로또 숫자의 범위가 적절하지 않습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }



}
