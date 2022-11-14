package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        CheckDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void CheckDuplicate(List<Integer> numbers){
        for(int i = 1;i<numbers.size();i++){
            if(numbers.get(i) == numbers.get(i-1)){
                throw new IllegalArgumentException();
            }
        }
    }



}
