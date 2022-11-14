package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningNumber() {
        winningNumbers = new ArrayList<Integer>();
        bonusNumber = 0;
    }

    private String inputWinningNumbers() {
        System.out.println(Message.EnterWinningNumberMessage);
        return Console.readLine();
    }

    private String inputBonusNumber() {
        System.out.println(Message.EnterBonusNumberMessage);
        return Console.readLine();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
