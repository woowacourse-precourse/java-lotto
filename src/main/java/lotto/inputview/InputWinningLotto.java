package lotto.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputWinningLotto {
    public String input() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers;
    }
}
