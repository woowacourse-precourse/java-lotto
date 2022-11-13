package lotto.View;

import java.util.List;
import lotto.Model.Buyer;
import lotto.Model.Lotto;

public class OutputView {

    public static final String PRINT_NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
    public static final int ZERO = 0;
    public static void printBuyerLotto(Buyer buyer){
        int count = buyer.getPurchaseCount();
        System.out.printf(PRINT_NUMBER_OF_LOTTO, count);
        System.out.println();
        printLottoWallet(buyer.getLottoWallet());
    }
    public static void printLottoWallet(List<Lotto> wallet ){
        for(int i = ZERO; i<wallet.size(); i++){
            System.out.println(wallet.get(i).getNumbers());
        }
    }
    public static void printError(String Error){
        System.out.println(Error);
    }
}
