package lotto;

import java.util.ArrayList;

public class Prize {
    private final LottoRank rankResult;
    public Prize(ArrayList<Integer> winningNumbers, Lotto lotto, int bounus) {
        this.rankResult = resultPrize(winningNumbers, lotto, bounus);
    }
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

    private static LottoRank rank(int sameNumbers, boolean sameBounus){
        switch (sameNumbers) {
            case 6:
                return LottoRank.FIRST;
            case 5:
                if(sameBounus){
                    return LottoRank.SECOND;
                }
                else {
                    return LottoRank.THIRD;
                }
            case 4:
                return LottoRank.FOURTH;
            case 3:
                return LottoRank.FIFTH;
            default:
                return LottoRank.NOTHING;
        }
    }
    public static LottoRank resultPrize(ArrayList<Integer> winningNumbers, Lotto lotto, int bounus){
        int sameWinningNumbers = checkForWinningNumber(winningNumbers, lotto);
        boolean sameBounusNumber = checkForSameBounusNumber(lotto, bounus);
        return rank(sameWinningNumbers, sameBounusNumber);
    }

    public String print() {
//        System.out.println(rankResult);
        return String.valueOf(rankResult);
    }
}
