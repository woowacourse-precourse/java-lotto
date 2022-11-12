package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public Lotto getAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        for (String number : input.split(",")) {
            int integer = Integer.parseInt(number);
            answerNumbers.add(integer);
        }
        return new Lotto(answerNumbers);
    }
}