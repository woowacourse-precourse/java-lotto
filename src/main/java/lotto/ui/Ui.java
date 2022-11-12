package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Ui {
    public String inputBalance() {
        System.out.println("구입 금액을 입력해 주세요.");
        String in = Console.readLine();

        return in;
    }
}
