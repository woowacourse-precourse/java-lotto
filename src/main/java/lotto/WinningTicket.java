package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class WinningTicket extends Lotto {
    private int bonusNumber = 0;

    public WinningTicket() {
        inputBonusNumber();
        super(inputNumbers());
    }

    private List<Integer> inputNumbers() {
    }

    private void inputBonusNumber() {
        String userInput = "";

        System.out.println("보너스 번호를 입력해 주세요.");
        userInput = Console.readLine();
        validateBonusNumber(userInput);
        this.bonusNumber = Integer.parseInt(userInput);
    }
}