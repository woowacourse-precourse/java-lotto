package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlapsFind(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 부족!");
        }
    }
    private void overlapsFind(List<Integer> numbers){
        Set<Integer> overlapTest = new HashSet<>();
        for(int nowNumber : numbers){
            overlapTest.add(nowNumber);
        }
        if(overlapTest.size()!=6)
            throw new IllegalArgumentException("[ERROR] 중복 숫자발견");
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
    // TODO: 추가 기능 구현
}
