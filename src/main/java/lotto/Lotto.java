package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 당첨 번호를 잘못 입력 하셨습니다.");
        }
        for(int n:numbers){
            if(n<1 || n>45 || Collections.frequency(numbers,n)!=1){
                throw new IllegalArgumentException("[Error] 당첨 번호를 잘못 입력 하셨습니다.");
            }
        }
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
