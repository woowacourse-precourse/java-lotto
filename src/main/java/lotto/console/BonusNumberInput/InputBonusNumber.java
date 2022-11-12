package lotto.console.BonusNumberInput;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputBonusNumber {

    public int getAndVerifyBonusNumber(List<Integer> winningNumbers) {
        int number = getBonusNumber();
        verifyBonusNumberBetween1and45(number);
        verifyBonusNumberDuplicateWinningNumber(winningNumbers, number);

        return number;
    }

    private int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private void verifyBonusNumberBetween1and45(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new RuntimeException("[ERROR] 1부터 45 사이의 숫자를 입력해주세요");
        }
    }

    private void verifyBonusNumberDuplicateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException("[ERROR] 당첨 번호에 들어있는 숫자입니다 다른 숫자 입력해야합니다.");
        }
    }
}
