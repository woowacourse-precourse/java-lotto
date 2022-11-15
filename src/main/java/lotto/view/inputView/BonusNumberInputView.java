package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputView {
    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}
