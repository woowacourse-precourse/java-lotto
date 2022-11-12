package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String push() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String push2() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String push3() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
