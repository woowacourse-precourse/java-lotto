package lotto.domain;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNum {

    public int makeNewBonusNum(List<Integer> winningNum) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputString = Console.readLine();
        int input = Integer.parseInt(inputString);
        validation(input, winningNum);
        return input;
    }

    private void validation(int input, List<Integer> winningNum) throws IllegalArgumentException{
        duplicateWithWinningNum(input, winningNum);
        rangeCheck(input);
    }

    private void rangeCheck(int input) throws IllegalArgumentException {
        if (input <= 0 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    private static void duplicateWithWinningNum(int input, List<Integer> winningNum) {
        if (winningNum.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");
        }
    }
}
