package view;

import lotto.Lotto;
import lotto.LottoResult;

public class UserOutputView {

    public static void printPurchaseLottoNumber(Lotto lotto){
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult){
        lottoResult.getWinningResult();
    }
}
