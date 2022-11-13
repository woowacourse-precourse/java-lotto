package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
    }

    // TODO: 추가 기능 구현
    public int compareNumber(List<Integer> winningNumber){
        int count = 0;
        for(int i=0;i<6;i++){
            if(numbers.contains(winningNumber.get(i))){
                count+=1;
            }
        }
        return count;
    }

    public boolean checkBonus(int bonus){
        for(int i=0;i<6;i++){
            if(numbers.contains(bonus))
                return true;
        }
        return false;
    }

}
