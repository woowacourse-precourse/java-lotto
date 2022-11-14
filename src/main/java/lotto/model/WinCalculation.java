package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCalculation {
    private int count=0;
    private boolean bonusCheck = true;
    List<List<Object>> rank = new ArrayList<>();

    public int winCount(List<Integer> win, List<Integer> number){
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

    private void winCalculation(){
        this.count = 0;
        this.bonusCheck = true;
    }

    public boolean bonusNumber(int bonus, List<Integer>number) {
        for(Integer numIndex : number) {
            if(numIndex == bonus) {
                return true;
            }
        }
        return false;
    }

    public List<List<Object>> winCal(List<Integer> win, List<List<Integer>>lottos,int bonus) {
        for(int i=0;i< lottos.size();i++){
            winCalculation();
            winCount(win,lottos.get(i));
            if(count == 5) {
               bonusCheck =  bonusNumber(bonus,lottos.get(i));
            }
            rank(count,bonusCheck);
        }
        System.out.println(rank);
        return rank;
    }

    private void rank(int count, boolean bonusCheck){
        rank.add(new ArrayList<>(Arrays.asList(count,bonusCheck)));
    }
}
