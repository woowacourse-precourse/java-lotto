package lotto;

import java.util.List;

public class LottoResult {

    public static int compareLotteryNumbers(List<Integer> winningNumber, List<Integer>ticketNumber){
        int matchCount=0;
        for(int numberIndex=0; numberIndex<6; numberIndex++){
            if(ticketNumber.contains(winningNumber.get(numberIndex))){
                matchCount++;
            }
        }
        return matchCount;
    }


}
