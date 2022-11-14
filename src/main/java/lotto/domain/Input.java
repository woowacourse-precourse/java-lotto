package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int pay = 0;
    public List<Integer> numbers = new ArrayList<>();
    public int bonus = 0;
    public int payForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.valueOf(Console.readLine())/1000;
        return pay;
    }
    public List<Integer> winningNumber () {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String number : input.split(",")){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.valueOf(Console.readLine());
        return bonus;
    }
}
