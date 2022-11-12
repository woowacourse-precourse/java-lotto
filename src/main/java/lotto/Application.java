package lotto;

import lotto.domain.Manager;
import lotto.ui.Input;

public class Application {
    public static void main(String[] args) {
        try {
            Operator operator = new Operator();
            operator.purchaseLottoTable();
            operator.notifySumOfResult(operator.compareWinningLottoNumbers());
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}
