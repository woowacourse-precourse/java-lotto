package lotto.views;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.lotto.Lottos;
import lotto.utils.Constants;

public class LottoPurchaseView {
    public static String printPurchaseLotto(){
        System.out.println(Constants.PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public static void printPurchaseLottoNumber(Lottos lottos){
        System.out.println(lottos.getLottoCount()+Constants.PURCHASE_LOTTO_COUNT_MESSAGE);
        System.out.print(lottos);
    }
}
