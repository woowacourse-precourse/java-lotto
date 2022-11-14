package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 부족!");
        }
    }
    //TODO 상수처리하기
    public boolean overlapsFind(List<Integer> numbers){
        Set<Integer> overlapTest = new HashSet<>();
        // Collections.addAll 기능을 사용해보기
        for(int nowNumber : numbers){
            overlapTest.add(nowNumber);
        }
        if(overlapTest.size()!=6)
            return false;
        return true;
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
}
