package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class Winnings {
    private int numberOne = 2000000000;
    private int numberTwo = 30000000;
    private int numberThree = 1500000;
    private int numberFour = 50000;
    private int numberFive = 5000;

    public int pay(List<WonLotto> myCount)
    {
        int myPoint =0;
        for (int i=0;i<myCount.size();i++)
        {
            if(myCount.get(i).getLottoCount()==6){
                myPoint=+numberOne;
            }else if(myCount.get(i).getLottoCount()==5&&myCount.get(i).getBonusCount()==1) {
                myPoint=numberTwo;
            }else if(myCount.get(i).getLottoCount()==5&&myCount.get(i).getBonusCount()==0){
                myPoint=numberThree;
            }else if(myCount.get(i).getLottoCount()==4){
                myPoint=numberFour;
            }else if(myCount.get(i).getLottoCount()==3){
                myPoint=numberFive;
            }
        }
        return myPoint;
    }
    public int[] sameCount(List<WonLotto> myCount){
        List<Integer> myRanking = new ArrayList<>(List.of(0,0,0,0,0));
        for (int i=0;i<myCount.size();i++)
        {
            if(myCount.get(i).getLottoCount()==6){
                myRanking.get(0)+numberOne;
            }else if(myCount.get(i).getLottoCount()==5&&myCount.get(i).getBonusCount()==1) {
                myRanking[1]=numberTwo;
            }else if(myCount.get(i).getLottoCount()==5&&myCount.get(i).getBonusCount()==0){
                myRanking[2]=numberThree;
            }else if(myCount.get(i).getLottoCount()==4){
                myRanking[3]=numberFour;
            }else if(myCount.get(i).getLottoCount()==3){
                myRanking[4]=numberFive;
            }
        }
        return myRanking;
    }
}
