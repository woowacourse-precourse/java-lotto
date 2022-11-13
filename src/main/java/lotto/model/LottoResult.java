package lotto.model;

import lotto.view.ResultView;

import java.util.List;

public class LottoResult {
    public static int count;
    public static int purchaseAmount;
    public static List<Lotto> lottos;

    public static Lotto winNumber;
    public static int bonusNumber;

    public static void showPurchaseCount(int count){
        ResultView.printLottoCount(count);
    }

    public static void printLottoList(){
        ResultView.printLottoList(LottoResult.lottos);
    }
}
