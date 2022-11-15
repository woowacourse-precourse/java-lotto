package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {
    private final List<Integer> WINNER_NUMBER;
    private final int BONUS_NUMBER;

    public WinNumber(){
        WINNER_NUMBER = winnerNumber();
        BONUS_NUMBER = bonusNumber();
    }
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

    private int bonusNumber() {
        int bonusNum;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());

        return bonusNum;
    }

    public List<Integer> getWINNER_NUMBER() {
        return WINNER_NUMBER;
    }

    public int getBONUS_NUMBER() {
        return BONUS_NUMBER;
    }
}
