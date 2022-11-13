package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int getPurchasingAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int amount = Integer.parseInt(Console.readLine());

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 급액은 1000원 단위여야 합니다.");
        }

        return amount;
    }
}
