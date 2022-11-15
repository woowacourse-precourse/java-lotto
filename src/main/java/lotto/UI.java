package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {

    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");

        int amount = Integer.parseInt(Console.readLine());

        return amount;
    }

}
