package lotto;

import java.util.List;

import static lotto.Utils.*;


public class Application {

    public static void main(String[] args) {
        try{
            int purchase = getPurchase();
            Buyer buyer = new Buyer(purchase);

            Lotto winningLotto = new Lotto(getWinningNums());
            int bonusNum = getBonusNum();
            Winning winning = new Winning(winningLotto, bonusNum);

            buyer.calResult(winning);


        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
