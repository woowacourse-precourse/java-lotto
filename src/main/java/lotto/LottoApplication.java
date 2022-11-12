package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoApplication {
    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
