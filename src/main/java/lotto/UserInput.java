package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Exception.*;

public class UserInput {
    public static int moneyInput() {
        int money;
        String input = Console.readLine();
        try {
            money = inputTypeError(input);
            moneyInputError(money);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            throw new IllegalArgumentException();
        }
    }

    public static Integer bonusNumInput(List<Integer> winNums) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String tmp = Console.readLine();
        //예외 확인
        inputTypeError(tmp);
        int bonus = Integer.parseInt(tmp);
        rangeError(bonus);
        duplicate(winNums, bonus);
        return bonus;
    }

    public static List<Integer> winNumInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNums = new ArrayList<>();
        String input = Console.readLine();
        winNumInputError(input);
        String[] tmpNums = input.split(",");
        for (String e : tmpNums) {
            inputTypeError(e);
            int num = Integer.parseInt(e);
            rangeError(num);
            duplicate(winNums, num);
            winNums.add(num);
        }
        return winNums;
    }

}
