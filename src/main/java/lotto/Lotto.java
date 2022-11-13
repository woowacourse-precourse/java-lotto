package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int rank;
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
    public void printLotto(){
        System.out.println(numbers);
    }

    public int checkWin(WinningNumber winNum){
        int cnt = 0;
        for(int i = 0 ; i < numbers.size(); i++){
            List<Integer> winnumber = winNum.getNumbers();
            if(winnumber.contains(this.numbers.get(i))){
                cnt = cnt +1;
            }
        }
        if(cnt == 3){
            rank = 5;
        }
        if(cnt == 4){
            rank = 4;
        }
        if(cnt == 5){
            rank = 3;
            if(this.numbers.contains(winNum.getBonusNumber())){rank = 2;}
        }
        if(cnt == 6){
            rank = 1;
        }
        return rank;
    }

}
