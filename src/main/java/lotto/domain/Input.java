package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.console.InputMessage;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public String pay = "";
    public List<Integer> numbers = new ArrayList<>();
    public String bonus = "";
    public String payForLotto() {
        System.out.println(InputMessage.inputPay.getValue());
        pay = Console.readLine();
        return pay;
    }
    public List<Integer> winningNumber () {
        System.out.println(InputMessage.inputWinningNumber.getValue());
        String input = Console.readLine();
        for (String number : input.split(",")){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
    public String bonusNumber() {
        System.out.println(InputMessage.inputBonus.getValue());
        bonus = Console.readLine();
        return bonus;
    }
}
