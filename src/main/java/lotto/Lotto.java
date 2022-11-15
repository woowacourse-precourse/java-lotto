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
        if (numbers.size() != 6 || duplicate(numbers) ) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 오류");
        }
    }

    private boolean duplicate(List<Integer> numbers){
        boolean duplicate = false;
        for(int i = 0; i < numbers.size(); i++){
            for(int j = i; j< numbers.size(); j++){
                if(numbers.get(i) == numbers.get(j)){
                    duplicate = true;
                }
            }
        }return duplicate;
    }

    // TODO: 추가 기능 구현
}
