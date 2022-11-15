package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.MainNumber;
import lotto.domain.Ranker;

public class WinningNumberInputUI {
    private String mainNumberMessage = "당첨 번호를 입력해 주세요.";
    private String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public Ranker setWinningNumber() {
        System.out.println(mainNumberMessage);
        MainNumber mainNumber = new MainNumber(Console.readLine());
        System.out.println();

        System.out.println(bonusNumberMessage);
        BonusNumber bonusNumber = new BonusNumber(Console.readLine(), mainNumber.getNumbers());
        System.out.println();

        return new Ranker(mainNumber.getNumbers(), bonusNumber.getNumber());
    }
}
