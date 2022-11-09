package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.InputValid;

public class InputView {
    private static final String NUMBER_OF_USER_PRICE_INPUT_MESSAGE="구입금액을 입력해 주세요.";

    public static int getUserPriceNumber(){
        System.out.println(NUMBER_OF_USER_PRICE_INPUT_MESSAGE);
        String strUserPrice= Console.readLine();
        int userPrice=Integer.parseInt(strUserPrice);

        InputValid.checkPriceUnit(userPrice);
        return userPrice;
    }
}
