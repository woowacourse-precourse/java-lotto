package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.ConstValue;

public class PriceGetter {
    private static final String INPUT_REQUEST_MESSAGE = "구입금액을 입력해주세요";

    public int getBuyingMoney() throws IllegalArgumentException{
        int buyingMoney;
        try {
            System.out.println(INPUT_REQUEST_MESSAGE);
            buyingMoney = Integer.parseInt(Console.readLine());
            if (buyingMoney % ConstValue.Numbers.PRICE_PER_LOTTO != 0) {
                throw new IllegalArgumentException(ConstValue.ErrorMessages.INDIVISIBLE_BY1000_MESSAGE);
            }
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ConstValue.ErrorMessages.NOT_NUMBER_MESSAGE);
        }

        return buyingMoney;
    }
}
