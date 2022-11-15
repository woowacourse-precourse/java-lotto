package lotto;

import static lotto.Utils.*;


public class Application {

    public static void main(String[] args) {
        try{
            int purchase = getPurchase();
            Buyer buyer = new Buyer(purchase);

            Lotto winningLotto = new Lotto(getWinningNums());
            int bonusNum = getBonusNum();
            Winning winning = new Winning(winningLotto, bonusNum);

            buyer.simulate(winning);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
