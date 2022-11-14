package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class PriceGetter {
    private static final String INPUT_REQUEST_MESSAGE = "구입금액을 입력해주세요";
    private static final String INDIVISIBLE_BY10_MESSAGE = "[ERROR] 1000단위의 숫자를 입력해주세요.";
    private static final String NOT_NUMBER_MESSAGE = "[ERROR] '숫자' 를 입력해주세요.";

    public int getBuyingMoney() throws IllegalArgumentException{
        int buyingMoney;
        try {
            System.out.println(INPUT_REQUEST_MESSAGE);
            buyingMoney = Integer.parseInt(Console.readLine());
            if (buyingMoney % 1000 != 0) {
                throw new IllegalArgumentException(INDIVISIBLE_BY10_MESSAGE);
            }
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }

        return buyingMoney;
    }
}
