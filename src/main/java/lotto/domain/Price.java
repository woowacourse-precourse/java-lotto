package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Price {

    static String input;

    public int inputPurchaseAmount() {
        input = Console.readLine();
        validateNumbers(input);
        validateDivide1000Won(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private void validateDivide1000Won(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나눠떨어지지 않습니다.");
        }
    }

    private void validateNumbers(String price) {
        for (char c : price.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 금액이 숫자가 아닙니다.");
            }
        }
    }

    public int divideAmountTo1000Won() {
        int count = Integer.parseInt(input);
        return count / Constant.DIVIDE_MONEY;
    }
}
