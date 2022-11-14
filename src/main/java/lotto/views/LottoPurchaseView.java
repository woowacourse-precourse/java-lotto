package lotto.views;

import camp.nextstep.edu.missionutils.Console;

import lotto.utils.Constants;

public class LottoPurchaseView {
    public static String purchaseLotto(){
        System.out.println(Constants.PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
