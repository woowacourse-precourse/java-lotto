package lotto.util;

import lotto.util.MatchUtil;

import java.util.List;

import static lotto.model.WinningPrize.*;

public class CalculateWinStatics {
    private MatchUtil matchUtil = new MatchUtil();
    public static int totalPrice=0,three=0,four=0,five=0,fiveAndBonus=0,six=0;
    public void winningStatics(List<List<Integer>> lottos,List<Integer> winningNumber,int bonusNumber){
        for(List<Integer> list:lottos){
            int cntWinning = matchUtil.matchWinningNumber(list,winningNumber);
            int cntBonus = matchUtil.matchBonusNumber(list,bonusNumber);
            correctNumber(cntWinning,cntBonus);
        }
    }

    private void correctNumber(int cntWinning,int cntBonus){
        if(cntWinning==3){
            totalPrice += FIVE_THOUSAND.getPrize();
            three++;
            return;
        }
        if(cntWinning==4){
            totalPrice += FIFTY_THOUSAND.getPrize();
            four++;
            return;
        }
        if(cntWinning==5 && cntBonus==1){
            totalPrice += THIRTY.getPrize();
            fiveAndBonus++;
            return;
        }
        if(cntWinning==5){
            totalPrice += FIFTEEN.getPrize();
            five++;
            return;
        }
        if(cntWinning==6){
            totalPrice += TWO_HUNDRED.getPrize();
            six++;
        }
    }
}
