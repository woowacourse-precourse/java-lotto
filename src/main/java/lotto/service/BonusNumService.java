package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.domain.ExceptionMessage;

import java.util.List;

public class BonusNumService {

    public int make(List<Integer> winningNum) {
        System.out.println(Constants.INPUT_REQUEST_BONUS_NUM);

        String inputString = Console.readLine();

        int input = toInt(inputString);

        validation(input, winningNum);

        return input;
    }

    private void validation(int input, List<Integer> winningNum) throws IllegalArgumentException{
        duplicateWithWinningNum(input, winningNum);
        rangeCheck(input);
    }

    private static int toInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NUMERIC.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void rangeCheck(int input) throws IllegalArgumentException {
        if (input <= Constants.NUMBER_RANGE_START || input > Constants.NUMBER_RANGE_END) {
            System.out.println(ExceptionMessage.LOTTO_NUMBER_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void duplicateWithWinningNum(int input, List<Integer> winningNum) {
        if (winningNum.contains(input)) {
            System.out.println(ExceptionMessage.DUPLICATE_NUM_BONUS.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
