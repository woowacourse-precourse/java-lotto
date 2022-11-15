package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateTest(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호가 6자리가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
    private void duplicateTest(List<Integer> numbers){
        Set<Integer> numbersTest = new HashSet<>(numbers);
        if (numbersTest.size() != numbers.size()){
            System.out.println("[ERROR] 중복된 번호가 존재합니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }
    public List<Integer> getLottoNumbers(){
        return this.numbers;
    }
}
