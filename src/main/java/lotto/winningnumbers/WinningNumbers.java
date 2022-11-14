package lotto.winningnumbers;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbers {
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_CLASSIFICATION_CRITERIA = ",";
    private static final String INVALIDATE_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALIDATE_DUPLICATION = "[ERROR] 중복되는 수를 입력할 수 없습니다.";

    private void inputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    private void inputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public List<Integer> input() {
        inputWinningNumberMessage();

        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        String[] inputNumberArr = inputNumber.split(WINNING_NUMBER_CLASSIFICATION_CRITERIA);

        for (String number : inputNumberArr) {
            validateRange(Integer.parseInt(number));
            validateDuplication(winningNumbers, Integer.parseInt(number));
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        inputBonusNumberMessage();

        int bonusNumber = Integer.parseInt(Console.readLine());

        validateRange(bonusNumber);

        return bonusNumber;
    }

    private void validateRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALIDATE_RANGE_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> winning, int number) {
        if (winning.contains(number)) {
            throw new IllegalArgumentException(INVALIDATE_DUPLICATION);
        }
    }
}
