package util.input.lotto;

import static util.input.global.InputUtil.getInput;

import lotto.Lotto;

public class BonusNumberInputUtil {
    public static int getBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = getInput();

        return Integer.parseInt(bonusNumber);
    }
}
