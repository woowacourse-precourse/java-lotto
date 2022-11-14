package lotto.Output;

import java.util.Arrays;

public class StatisticOutput {
    public void getStatisticOutput(int three, int four, int five, int six_YesBonus, int six) {
        //list로 받아봐야 겠는데
        for(PrintWinning winMessage: PrintWinning.values()){
            for(<Integer> winNum : winNums){
                System.out.println(winMessage.message(),winNum);
            }
        }
    }
}
