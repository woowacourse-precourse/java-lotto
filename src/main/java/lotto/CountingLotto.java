package lotto;

import java.util.ArrayList;
import java.util.List;

public class CountingLotto {

    private int count;


    public List<Integer> hasCheckNumber(List<List> user,
                                        List<Integer> random, int lottoBonusNumber) {

        List<Integer> winningList = new ArrayList<>();
        for (List<Integer> userLotto:
             user) {
            count = 0;
            for (int randomNumber:
                 random) {
                count = hasCheckContain(userLotto,randomNumber);
            }
            count = hasCheckBonusNumber(userLotto,lottoBonusNumber);
            winningList.add(count);
        }

        return winningList;
    }
    private int hasCheckContain(List<Integer> userLotto,int randomNumber){
        if(userLotto.contains(randomNumber)){
            count = count + 1;
        }
        return count;
    }
    private int hasCheckBonusNumber(List<Integer> userLotto,int BonusNumber){
        if(userLotto.contains(BonusNumber)&&count==5){
            count = count + 2;
        }
        return count;
    }

}
