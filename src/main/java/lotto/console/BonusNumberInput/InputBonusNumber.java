package lotto.console.BonusNumberInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.chart.NumberChart;

import java.util.List;

public class InputBonusNumber {

    public int getAndVerifyBonusNumber(List<Integer> winningNumbers) {
        String numbers = getBonusNumber();
        verifyItIsNumber(numbers);
        int number = Integer.parseInt(numbers);
        verifyBonusNumberBetween1and45(number);
        verifyBonusNumberDuplicateWinningNumber(winningNumbers, number);

        return number;
    }

    private String getBonusNumber() {
        return Console.readLine();
    }

    private void verifyBonusNumberBetween1and45(int bonusNumber) {
        if (!(NumberChart.MIN_NUMBER.getValue() <= bonusNumber && bonusNumber <= NumberChart.MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(" 1부터 45 사이의 숫자를 입력해주세요");
        }
    }

    private void verifyBonusNumberDuplicateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(" 당첨 번호에 들어있는 숫자입니다 다른 숫자 입력해야합니다.");
        }
    }

    private void verifyItIsNumber(String bonusNumber) {
        String regex = "[0-9]+";
        if (!(bonusNumber.matches(regex))) {
            throw new IllegalArgumentException(" 숫자만 입력하세요");
        }
    }

}
