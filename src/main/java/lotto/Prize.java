package lotto;

import java.util.ArrayList;

public class Prize {
    private static int checkForWinningNumber(ArrayList<Integer> winningNumbers, Lotto lotto){
        int same = 0;
        for(Integer winningNumber: winningNumbers){
            if(lotto.hasWinningNumber(winningNumber)){
                same += 1;
            }
        }
        return same;
    }


    public static void resultPrize(ArrayList<Integer> winningNumbers, Lotto lotto, int bounus, int customerBounus){
        int sameWinningNumbers = checkForWinningNumber(winningNumbers, lotto);


    }
}
