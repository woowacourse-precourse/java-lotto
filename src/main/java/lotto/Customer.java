package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
    public int wantBuyAmountInput() {
        return Integer.parseInt(readLine());
    }

    public void validWnatByAmountInput(int wantBuyAmount) {
        if (wantBuyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 이하의 단위는 입력 불가능 합니다.");
        }
    }
}

