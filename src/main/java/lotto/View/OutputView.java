package lotto.View;

import java.util.List;
import lotto.Model.Buyer;

public class OutputView {

    public static final String PRINT_NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
    public static final int ZERO = 0;
    public static void printBuyerLotto(Buyer buyer){
        int count = buyer.getPurchaseCount();
        System.out.printf(PRINT_NUMBER_OF_LOTTO, count);
        System.out.println();
        printLottoWallet(buyer.getLottoWallet());
    }
    public static void printLottoWallet(List<List<Integer>> wallet ){
        for(int i = ZERO; i<wallet.size(); i++){
            System.out.println(wallet.get(i));
        }
    }
    public static void printError(String Error){
        System.out.println(Error);
    }
}
