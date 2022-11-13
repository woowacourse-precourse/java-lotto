package controller;

import view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputController {
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
            }  catch (IllegalArgumentException e) {
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
