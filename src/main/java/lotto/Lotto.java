package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다.");
        }

        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 존재합니다.");
            throw new IllegalArgumentException();
        }

        for(Integer num : numbers){
            if(num < 1 || num > 45){
                throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력하세요.");
            }
        }

    }

    public void NumberRange(List<Integer> numbers) {

    }
    public List<Integer> GetNumbers(){
        return new ArrayList<>(this.numbers);
    }
}

