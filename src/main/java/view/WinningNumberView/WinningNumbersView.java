package view.WinningNumberView;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbersView {

    public String show() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        System.out.println();
        return numbers;
    }
}
