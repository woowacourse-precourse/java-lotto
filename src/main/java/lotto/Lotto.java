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
            throw new IllegalArgumentException();
        }
    }
    public void sort(){
        Collections.sort(this.numbers);
    }

    public int howManyMatches(Lotto win_lottery){
        int cnt =0;
        for(int i=0; i<6; i++){
            if(win_lottery.numbers.contains(this.numbers.get(i))){
                cnt++;
            }
        }
        return cnt;
    }

}
