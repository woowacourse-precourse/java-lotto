package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    public List<Integer> winnerNumber() {
        String inputWinNum;
        String[] numberSplit;
        List<Integer> winnerNumber = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinNum = Console.readLine();

        numberSplit = inputWinNum.split(",");

        for (String s : numberSplit) {
            winnerNumber.add(Integer.parseInt(s));
        }

        return  winnerNumber;
    }

    public int bonusNumber() {
        int bonusNum;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());

        return bonusNum;
    }
}
