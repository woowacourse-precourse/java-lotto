package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    private final Validate validate = new Validate();

    public Money requestMoney() {
        String input = Console.readLine();
        return new Money(input);
    }

    public WinningNumber requestWinningNumber() {
        String input = Console.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        for(String s : input.split(",")) {
            validate.IsRightFormatWinningNumber(s);
            winningNumber.add(Integer.parseInt(s));
        }
        return new WinningNumber(winningNumber);
    }

    public BonusNumber requestBonusNumber() {
        String input = Console.readLine();
        validate.IsRightFormatBonusNumber(input);
        return new BonusNumber(Integer.parseInt(input));
    }
}
