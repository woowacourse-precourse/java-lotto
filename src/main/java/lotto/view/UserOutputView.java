package lotto.view;

import java.util.List;
import lotto.constant.UserOutputMessage;

public class UserOutputView {

    public static void printPurchaseQuantity(int numberOfPurchasedLottos) {
        System.out.println(numberOfPurchasedLottos + UserOutputMessage.POSTFIX_NUMBER_OF_PURCHASES.getMessage());
    }

    public static void printPurchasedLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

}
