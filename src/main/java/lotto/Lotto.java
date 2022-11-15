package lotto;

import java.util.Collections;
import java.util.HashMap;
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
    public int rank(Lotto win_lottery, int bonus){
        HashMap<Integer,Integer> rank_map = new HashMap<>();
        rank_map.put(6,1);
        rank_map.put(5,3);
        rank_map.put(4,4);
        rank_map.put(3,5);

        int matches = howManyMatches(win_lottery);
        if (matches == 5 && numbers.contains(bonus)){
            return 2;
        }
        if (matches>=3){
            return rank_map.get(matches);
        }
        return 0;
    }

    public void printNumbers(){
        System.out.println(numbers);
    }
}
