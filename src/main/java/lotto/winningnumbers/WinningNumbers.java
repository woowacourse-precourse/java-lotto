package lotto.winningnumbers;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.AllLottoMessage;

public class WinningNumbers {
    private void inputWinningNumberMessage() {
        System.out.println(AllLottoMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    private void inputBonusNumberMessage() {
        System.out.println(AllLottoMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public List<Integer> input() {
        inputWinningNumberMessage();

        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        String[] inputNumberArr = inputNumber.split(AllLottoMessage.WINNING_NUMBER_CLASSIFICATION_CRITERIA.getMessage());

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
            throw new IllegalArgumentException(AllLottoMessage.INVALIDATE_RANGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> winning, int number) {
        if (winning.contains(number)) {
            throw new IllegalArgumentException(AllLottoMessage.INVALIDATE_DUPLICATION.getMessage());
        }
    }
}
