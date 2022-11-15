package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        return Integer.parseInt(input);
    }
}
