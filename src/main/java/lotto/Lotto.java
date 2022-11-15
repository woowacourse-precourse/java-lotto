package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        try {
            validate(numbers);
            validateSameNumber(numbers);

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void validateSameNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호 중에서 중복된 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumber(){
        return this.numbers;
    }

}
