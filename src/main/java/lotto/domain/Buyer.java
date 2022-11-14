package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Buyer {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    int lottoAmount;

    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    static void validDivisionByThousand(int purchaseAmount){
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
    static int inputLottoAmount(){
        int purchaseAmount;
        String inputValue;

        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        inputValue = Console.readLine();

        validConsistByNumber(inputValue);
        purchaseAmount = Integer.parseInt(inputValue);
        validDivisionByThousand(purchaseAmount);

        return purchaseAmount;
    }
}
