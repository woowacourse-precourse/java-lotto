package lotto;

import java.util.Collections;
import java.util.List;

public class LottoManager {
    private List<Integer> mynumbers;

    public List<Integer> lottomanager(List<Integer> mynumbers, int myCount){
        int count = myCount;
        for (int countstart = 1; countstart < count; countstart++) {
            new MyLotto(Collections.singletonList(count));
        }
        return this.mynumbers = mynumbers;
    }

    public int lotttoCompare(List<Integer> number, List<Integer> mynumbers){
        int result = 0;
        for(int i = 0; i < mynumbers.size(); i++){
            if(number.contains(mynumbers.get(i))){
                result += 1;
            }
        }
        return result;
    }

    public int countLotto(List<Integer> number, List<Integer> mynumbers){
        int goal = 0;
        for(int i = 0; i < mynumbers.size(); i++){
            if(number.get(i) == mynumbers.get(i)){
                goal += 1;
            }
        }
        return goal;
    }
}