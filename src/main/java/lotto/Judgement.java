package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgement {
    private int[] result;
    public Judgement(){
        this.result = new int[6];
    }
    public void checkWin(Set<Integer> winner,allLotto alllotto,String bonusNumber){
    for(int i=0;i<alllotto.sizeLotto();i++){
        Set<Integer> tempWinner=new HashSet<>();
        tempWinner.addAll(winner);
         Set<Integer> transfromLotto=alllotto.transformSet(alllotto.get(i));
         resultUpdate(result,checkPlaceWin(tempWinner,transfromLotto,bonusNumber));

    }
    }
    public int checkPlaceWin(Set<Integer> tempwinner,Set<Integer> transformLotto,String bonusNumber){
        tempwinner.retainAll(transformLotto);
        int place=0;
        if(tempwinner.size()==6){
            place= 1;
        }
        if(tempwinner.size()==5&&tempwinner.contains(Integer.parseInt(bonusNumber))){
            place= 2;
        }
        if(tempwinner.size()==5&&!tempwinner.contains(Integer.parseInt(bonusNumber))){
            place= 3;
        }
        if(tempwinner.size()==4){
            place= 4;
        }
        if(tempwinner.size()==3){
            place= 5;
        }
        if(tempwinner.size()<4){
            place= 0;
        }
        return place;
    }
    public void resultUpdate(int[] result,int place){
        result[place]++;
    }


}
