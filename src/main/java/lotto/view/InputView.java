package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String InputBuyAmount() {
        String buyAmount = readLine();
        return buyAmount;
    }

    public String InputWiningNumbers() {
        String winingNumbers = readLine();
        return winingNumbers;
    }

    public String InputBonusNumber() {
        String bonusNumber = readLine();
        return bonusNumber;
    }
}
