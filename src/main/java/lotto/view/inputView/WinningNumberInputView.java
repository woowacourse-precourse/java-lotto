package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberInputView {
    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }
}
