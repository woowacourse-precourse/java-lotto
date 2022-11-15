package lotto;

import lotto.domain.Buyer;
import lotto.domain.ResultPresenter;

public class Application {
    public static void main(String[] args) {
        try{
            Buyer buyer = new Buyer();
            buyer.buy();

            ResultPresenter myResult = new ResultPresenter();
            myResult.input();

            buyer.checkResult(myResult);
            buyer.printLottoResult();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

    }
}
