package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public String inputUserLottoBuyingPrice() {
        return Console.readLine();
    }
    public String[] inputWinningNumber() {
        String winningNumbers = Console.readLine();
        return winningNumbers.split(",");
    }
    public String inputBonusNumber() {
        return Console.readLine();
    }
}
