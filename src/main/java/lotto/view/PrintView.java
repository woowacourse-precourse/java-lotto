package lotto.view;

import lotto.util.MathUtil;

import java.util.List;

import static lotto.util.CalculateWinStatics.*;
import static lotto.model.GameMessage.*;
import static lotto.model.GameMessage.TOTAL_END;

public class PrintView {
    private MathUtil mathUtil = new MathUtil();
    public void printPurchased(int purchasePrice){
        System.out.println(mathUtil.divide(purchasePrice)+OUTPUT_PURCHASE_QUANTITY.getMessage());
    }

    public void printInputPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
    }

    public void printInputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
    }

    public void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void outputPurchaseQuantity(List<List<Integer>> lottos){
        for(List<Integer> lotto:lottos){
            System.out.println(lotto);
        }
    }

    public void printStatics(int purchasePrice){
        System.out.println(WINNING_STATICS.getMessage());
        System.out.println(DASH.getMessage());
        System.out.println(THREE_CORRECT.getMessage()+three+COUNT.getMessage());
        System.out.println(FOUR_CORRECT.getMessage()+four+COUNT.getMessage());
        System.out.println(FIVE_CORRECT.getMessage()+five+COUNT.getMessage());
        System.out.println(FIVE_AND_BONUS_CORRECT.getMessage()+fiveAndBonus+COUNT.getMessage());
        System.out.println(SIX_CORRECT.getMessage()+six+COUNT.getMessage());
        System.out.println(TOTAL_START.getMessage()+mathUtil.makeRateOfReturn(purchasePrice,totalPrice)+TOTAL_END.getMessage());
    }
}
