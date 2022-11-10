package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;

public class PriceGetter {
    private final static IllegalArgumentException ie = new IllegalArgumentException();

    public int getBuyingMoney() throws IllegalArgumentException {
        int buyingMoney;

        try {
            System.out.println("구입금액을 입력해주세요");
            buyingMoney = Integer.parseInt(Console.readLine());

            if (buyingMoney % 1000 != 0) {
                throw ie;
            }
        } catch (NumberFormatException ne) {
            throw ie;
        }

        return buyingMoney;
    }
}
