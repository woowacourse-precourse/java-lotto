package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
    public String getWinningLottoNumbers() {
        System.out.println(Messages.WINNING_NUMBER.getMessage());
        return Console.readLine();
    }
    public String getBonusLottoNumber() {
        System.out.println(Messages.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
