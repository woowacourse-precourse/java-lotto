package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        inputWinningNumberException(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void inputWinningNumberException(List<Integer> numbers){
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1||numbers.get(i)>45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for(int i=0;i<numbers.size()-1;i++){
            if(numbers.get(i)==numbers.get(i+1))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되어서는 안됩니다.");
        }
    }

    public int compareNumber(List<Integer> winningNumber){
        int count = 0;
        for(int i=0;i<6;i++){
            if(numbers.contains(winningNumber.get(i))){
                count+=1;
            }
        }
        return count;
    }

    public boolean checkBonus(int count, int bonus){
        if(count==5) {
            for (int i = 0; i < 6; i++) {
                if (numbers.contains(bonus))
                    return true;
            }
        }
        return false;
    }
}
