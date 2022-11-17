package controller;

import domain.WinningNumber;
import view.InputView;
import camp.nextstep.edu.missionutils.Console;
import resources.Error;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public WinningNumber winningNumber = new WinningNumber(List.of());

    public int inputMoney() {
        InputView.pushPurchasingMoney();
        String purchasingMoney = Console.readLine();
        Validator.isNumber(purchasingMoney,Error.NUMBER);
        int money = Integer.parseInt(purchasingMoney);
        Validator.isDivideBy1000(money,Error.THOUSAND);
        return money;
    }

    public List<Integer> inputWinningNumber() {
        InputView.pushWinningNumber();
        String numbers = Console.readLine();
        String[] pureNumbers = numbers.split(",");
        Validator.validateWinningNumber(pureNumbers);
        List<Integer> winningNumbers = splitOneByOne(pureNumbers);
        winningNumber = new WinningNumber(winningNumbers);
        return winningNumber.getWinningNumbers();
    }

    public int inputBonusNumber() {
        InputView.pushBonusNumber();
        String number = Console.readLine();
        int bonusNumber = Validator.validateBonusNumber(number);
        winningNumber.hasBeenBonusNumber(bonusNumber, Error.ONLY_ONE);
        return bonusNumber;
    }

    public List<Integer> splitOneByOne(String[] pureNumbers) {
        List<Integer> pureWinningNumbers = new ArrayList<>();
        for(String s : pureNumbers) {
            pureWinningNumbers.add(Integer.parseInt(s));
        }
        return pureWinningNumbers;
    }
}
