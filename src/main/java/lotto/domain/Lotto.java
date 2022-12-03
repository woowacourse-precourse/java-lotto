package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
        }
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1||numbers.get(i)>45){
                throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45까지입니다.");
            }
            if(numbers.contains(numbers.get(i))){
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
        }
    }
}
