package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String PURCHASE_AMOUNT_INPUT_MESSAGE= " ";

    public String getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

}
