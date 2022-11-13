package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoSeller {
    int money;
    int piece;
    int change;

    void takeMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        piece = money/1000;
        change = money%1000;
    }
}
