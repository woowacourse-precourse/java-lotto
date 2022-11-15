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

    private static boolean checkForSameBounusNumber(Lotto lotto, int bounus){
        return lotto.hasWinningNumber(bounus);
    }

    private static boolean checkSecondPrize(int sameNumbers, boolean bounus){
        return sameNumbers == 5 && bounus;
    }
    public static void resultPrize(ArrayList<Integer> winningNumbers, Lotto lotto, int bounus){
        int sameWinningNumbers = checkForWinningNumber(winningNumbers, lotto);
        boolean sameBounusNumber = checkForSameBounusNumber(lotto, bounus);

    }
}
