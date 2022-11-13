package controller;

import domain.WinningNumber;
import view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public WinningNumber winningNumber = new WinningNumber(List.of());

    public int inputMoney() {
        while (true) {
            try {
                InputView.pushPurchasingMoney();
                String purchasingMoney = Console.readLine();
                int money = Validator.isNumber(purchasingMoney);
                Validator.isDivideBy1000(money);
                return money;
            } catch(IllegalArgumentException e) {
                InputView.showMoneyError();
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                InputView.pushWinningNumber();
                String numbers = Console.readLine();
                String[] pureNumbers = numbers.split(",");
                Validator.validateWinningNumber(pureNumbers);
                List<Integer> winningNumbers = splitOneByOne(pureNumbers);
                winningNumber = new WinningNumber(winningNumbers);
                return winningNumber.getWinningNumbers();
            }  catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                InputView.pushBonusNumber();
                String number = Console.readLine();

            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    public List<Integer> splitOneByOne(String[] pureNumbers) {
        List<Integer> pureWinningNumbers = new ArrayList<>();
        for(String s : pureNumbers) {
            pureWinningNumbers.add(Integer.parseInt(s));
        }
        return pureWinningNumbers;
    }
}
