package lotto.domain;

import java.util.Collection;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 개수를 확인 하세요.");
        }
    }

    private void duplication(List<Integer> numbers){
        for(int index1=0;index1<numbers.size();index1++){
            for(int index2=index1+1;index2<numbers.size();index2++){
                duplication2(numbers,index1,index2);
            }
        }
    }

    private void duplication2(List<Integer> numbers, int index1, int index2){
        if(numbers.get(index1).equals(numbers.get(index2))){
            throw new IllegalArgumentException("[ERROR] 중복 숫자를 확인하세요.");
        }

    }

    // TODO: 추가 기능 구현
}
