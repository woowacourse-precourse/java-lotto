package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private InputUtil inputUtil = new InputUtil();
    private RandomUtil randomUtil = new RandomUtil();
    private MatchUtil matchUtil = new MatchUtil();
    private RateOfReturn rateOfReturn = new RateOfReturn();
    private int purchasePrice,bonusNumber,totalPrice=0,three=0,four=0,five=0,fiveAndBonus=0,six=0;
    private List<Integer> winningNumber;
    private List<List<Integer>> lottos = new ArrayList<>();
    public void gameStart(){
        System.out.println(Constant.INPUT_PURCHASE_PRICE);
        purchasePrice = inputUtil.inputPurchasePrice();

        System.out.println(divide(purchasePrice)+Constant.OUTPUT_PURCHASE_QUANTITY);
        outputPurchaseQuantity();

        System.out.println(Constant.INPUT_WINNING_NUMBER);
        winningNumber = inputUtil.inputWinningNumber();

        System.out.println(Constant.INPUT_BONUS_NUMBER);
        bonusNumber = inputUtil.inputBonusNumber();

        System.out.println(Constant.WINNING_STATICS);
        System.out.println(Constant.DASH);
        winningStatics();
        System.out.println(Constant.THREE_CORRECT+three+Constant.COUNT);
        System.out.println(Constant.FOUR_CORRECT+four+Constant.COUNT);
        System.out.println(Constant.FIVE_CORRECT+five+Constant.COUNT);
        System.out.println(Constant.FIVE_AND_BONUS_CORRECT+fiveAndBonus+Constant.COUNT);
        System.out.println(Constant.SIX_CORRECT+six+Constant.COUNT);
        System.out.println(Constant.TOTAL_START+rateOfReturn.makeRateOfReturn(purchasePrice,totalPrice)+Constant.TOTAL_END);
    }

    private int divide(int inputPurchasePrice){
        int divided = Math.floorDiv(inputPurchasePrice,Constant.THOUSAND);
        return divided;
    }

    private void outputPurchaseQuantity(){
        Lotto lotto;
        for(int i=0;i<divide(purchasePrice);i++){
            List<Integer> list = randomUtil.makeRandomNumber();
            lotto = new Lotto(list);
            System.out.println(lotto.toPrint());
            lottos.add(lotto.toPrint());
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
            totalPrice += Constant.FIVE_THOUSAND;
            three++;
            return;
        }
        if(cntWinning==4){
            totalPrice += Constant.FIFTY_THOUSAND;
            four++;
            return;
        }
        if(cntWinning==5){
            totalPrice += Constant.FIFTEEN;
            five++;
            return;
        }
        if(cntWinning==5 && cntBonus==1){
            totalPrice += Constant.THIRTY;
            fiveAndBonus++;
            return;
        }
        if(cntWinning==6){
            totalPrice += Constant.TWO_HUNDRED;
            six++;
        }
    }
}
