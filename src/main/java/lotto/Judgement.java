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
    public int[] getResult(){
        return this.result;
    }
    public void checkWin(Set<Integer> winner,allLotto alllotto,String bonusNumber){
    for(int i=0;i<alllotto.sizeLotto();i++){
        Set<Integer> tempWinner=new HashSet<>();
        tempWinner.addAll(winner);
         Set<Integer> transfromLotto=alllotto.transformSet(alllotto.get(i));
         resultUpdate(result,checkPlaceWin(tempWinner,transfromLotto,bonusNumber));

    }
    printResult(this.result);
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
        return place;
    }
    public void resultUpdate(int[] result,int place){
        result[place]++;
    }
    public void printResult(int[] result){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[1]+"개");
    }


}
