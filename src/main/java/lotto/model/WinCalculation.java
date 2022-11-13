package lotto.model;

import java.util.List;

public class WinCalculation {
    private int count=0;

    public int WinCount(List<Integer> win, List<Integer> number){
        for(Integer winIndex : win) {
            checkEqualNumber(winIndex,number);
        }
        return count;
    }

    private void checkEqualNumber(int winIndex, List<Integer>number){
        for(Integer numIndex:number){
            if(winIndex == numIndex){
                countAdd();
            }
        }
    }

    private void countAdd(){
        count++;
    }

}
