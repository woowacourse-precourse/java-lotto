package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
    public int wantBuyAmountInput() {
        validWantByAmountInput(Integer.parseInt(readLine()));
        return Integer.parseInt(readLine());
    }

    private void validWantByAmountInput(int wantBuyAmount) {
        if (wantBuyAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

