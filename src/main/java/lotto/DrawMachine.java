package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class DrawMachine {
    public List<Integer> drawNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        List<Integer> numbers = new ArrayList<>();
        for (String number : userInput.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int drawBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        return Integer.parseInt(userInput);
    }
}
