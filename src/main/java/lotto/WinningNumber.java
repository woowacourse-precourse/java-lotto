package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;

public class WinningNumber {

    Lotto lotto;
    int bonusNumber;

    private void inputWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        String input = Console.readLine();
        String[] inputList = input.split(",");

        validateForIllegalInput(inputList);

        for (int i = 0; i < inputList.length; i++) {
            int num = Integer.parseInt(inputList[i]);
            winningNumber.add(num);
        }

        validateForRange(winningNumber);
        lotto = new Lotto(winningNumber);
    }

    private void validateForIllegalInput(String[] inputList) {
        for (int i = 0; i < inputList.length; i++) {
            if (!inputList[i].matches("^[0-9]*$")) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
            }
        }
    }

    private void validateForRange(List<Integer> WinningNumber) {
        if (!WinningNumber.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
