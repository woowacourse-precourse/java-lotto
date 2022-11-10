package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Price {
    int input;

    public int purchaseAmount() {
        input = Integer.parseInt(Console.readLine());
        validateDivide1000Won(input);
        return input;
    }

    private void validateDivide1000Won(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나눠떨어지지 않습니다.");
        }
    }
}
