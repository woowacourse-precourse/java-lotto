package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {

    @Override
    public int paymentAmountInput() {
        int paymentAmount = Integer.parseInt(Console.readLine());
        return paymentAmount;
    }
}
