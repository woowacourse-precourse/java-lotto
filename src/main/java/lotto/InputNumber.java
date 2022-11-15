package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public List<Integer> winningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String a : inputWinningNumber.split(",")) {
            winningNumber.add(Integer.parseInt(a));
        }
        return winningNumber;
    }

    public String inputWinningNumber() {
        return Console.readLine();
    }

    public Integer bonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }

    public Integer Money(String money) {
        MoneyInputWrongMoney(money);
        return Integer.parseInt(money);
    }

    public void MoneyInputWrongMoney(String money) {
/*        try {
            Double.parseDouble(money);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]: 올바른 숫자가 아닙니다.");
            throw new NumberFormatException("[ERROR]: 올바른 숫자가 아닙니다.");
        }*/
        boolean isNumeric = money.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            System.out.println("[ERROR]: 올바른 숫자가 아닙니다.");
            throw new IllegalArgumentException("[ERROR]: 올바른 숫자가 아닙니다.");
        }

    }

    public String inputMoney() {
        return Console.readLine();
    }

    public void textWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public void textBounsNumber() {
        System.out.println("보너스 번호를 입력해주세요");
    }

    public void textTicketPrice() {
        System.out.println("구입 금액을 입력해주세요");
    }
}
