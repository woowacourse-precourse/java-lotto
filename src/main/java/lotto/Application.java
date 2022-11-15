package lotto;

import static lotto.Utils.*;


public class Application {

    public static void main(String[] args) {
        try{
            int purchase = getPurchase();
            Buyer buyer = new Buyer(purchase);



        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
