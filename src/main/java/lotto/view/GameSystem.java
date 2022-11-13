package lotto.view;

import lotto.controller.*;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.GameMessage.*;
import static lotto.model.GameNumber.THOUSAND;
import static lotto.model.WinningPrize.*;

public class GameSystem {
    private InputUtil inputUtil = new InputUtil();
    private RandomUtil randomUtil = new RandomUtil();
    private MatchUtil matchUtil = new MatchUtil();
    private RateOfReturn rateOfReturn = new RateOfReturn();
    private int purchasePrice,bonusNumber,totalPrice=0,three=0,four=0,five=0,fiveAndBonus=0,six=0;
    private List<Integer> winningNumber;
    private List<List<Integer>> lottos = new ArrayList<>();
    public void gameStart(){
        purchasePrice = inputUtil.inputPurchasePrice();

        System.out.println(divide(purchasePrice)+OUTPUT_PURCHASE_QUANTITY.getMessage());
        outputPurchaseQuantity();

        winningNumber = inputUtil.inputWinningNumber();

        bonusNumber = inputUtil.inputBonusNumber();

        System.out.println(WINNING_STATICS.getMessage());
        System.out.println(DASH.getMessage());
        winningStatics();
        System.out.println(THREE_CORRECT.getMessage()+three+COUNT.getMessage());
        System.out.println(FOUR_CORRECT.getMessage()+four+COUNT.getMessage());
        System.out.println(FIVE_CORRECT.getMessage()+five+COUNT.getMessage());
        System.out.println(FIVE_AND_BONUS_CORRECT.getMessage()+fiveAndBonus+COUNT.getMessage());
        System.out.println(SIX_CORRECT.getMessage()+six+COUNT.getMessage());
        System.out.println(TOTAL_START.getMessage()+rateOfReturn.makeRateOfReturn(purchasePrice,totalPrice)+TOTAL_END.getMessage());
    }

    private int divide(int inputPurchasePrice){
        int divided = Math.floorDiv(inputPurchasePrice,THOUSAND.getNumber());
        return divided;
    }

    private void outputPurchaseQuantity(){
        Lotto lotto;
        for(int i=0;i<divide(purchasePrice);i++){
            List<Integer> list = randomUtil.makeRandomNumber();
            lotto = new Lotto(list);
            System.out.println(lotto.getNumbers());
            lottos.add(lotto.getNumbers());
        }
    }

    private void winningStatics(){
        for(List<Integer> list:lottos){
            int cntWinning = matchUtil.matchWinningNumber(list,winningNumber);
            int cntBounus = matchUtil.matchBonusNumber(list,bonusNumber);
            correctNumber(cntWinning,cntBounus);
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
        if(cntWinning==5){
            totalPrice += FIFTEEN.getPrize();
            five++;
            return;
        }
        if(cntWinning==5 && cntBonus==1){
            totalPrice += THIRTY.getPrize();
            fiveAndBonus++;
            return;
        }
        if(cntWinning==6){
            totalPrice += TWO_HUNDRED.getPrize();
            six++;
        }
    }
}
