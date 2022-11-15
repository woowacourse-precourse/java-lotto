package view.WinningNumberView;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberView {

    public String show() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
