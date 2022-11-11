package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchaseAmount;

public class InputPurchaseAmount {
    public static PurchaseAmount input() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInteger(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자를 입력해야 합니다.");
        }
    }
}
