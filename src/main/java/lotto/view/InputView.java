package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력할 수 있습니다.");
        }
        return amount;
    }
}
