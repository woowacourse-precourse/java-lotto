package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void readInput() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(
                Console.readLine());
    }
}
