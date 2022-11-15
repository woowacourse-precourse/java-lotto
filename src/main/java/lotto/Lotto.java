package lotto;

import java.util.ArrayList;
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
            throw new IllegalArgumentException();
        }
        int frequency=0;
        for(int i = 0; i<numbers.size();i++){
            frequency = Collections.frequency(numbers, numbers.get(i));
            if(frequency != 1){
                System.out.println("[ERROR] 당첨번호를 중복되지 않게 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }
}
