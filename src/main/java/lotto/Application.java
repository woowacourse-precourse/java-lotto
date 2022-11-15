package lotto;

import java.util.List;

import static lotto.Utils.*;


public class Application {

    public static void main(String[] args) {
        try{
            int purchase = getPurchase();
            Buyer buyer = new Buyer(purchase);

            Lotto winningLotto = new Lotto(getWinningNums());



        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
