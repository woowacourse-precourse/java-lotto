package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class DrawMachine {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public void drawNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        for (String number : userInput.split(",")) {
            winningNumbers.add(Integer.valueOf(number));
        }
    }

    public void drawBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        bonusNumber = Integer.parseInt(userInput);
    }
}
