package lotto.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusNumber {
    public String input() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
