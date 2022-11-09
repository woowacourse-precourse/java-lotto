package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
    public int wantBuyAmountInput() {
        int wantBuyAmountInput = Integer.parseInt(readLine());
        validWantByAmountInput(wantBuyAmountInput);
        return wantBuyAmountInput;
    }

    private void validWantByAmountInput(int wantBuyAmount) {
        if (wantBuyAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

