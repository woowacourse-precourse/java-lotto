package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.domain.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class WinningNumService {

    public List<Integer> make() {

        List<Integer> tmp = new ArrayList<>();

        getInputAndValidate(tmp);

        return tmp;
    }

    private void getInputAndValidate(List<Integer> tmp) throws IllegalArgumentException{
        System.out.println(Constants.INPUT_REQUEST_WINNING_NUM);

        String numbersAsString = Console.readLine();

        for (String inputString : numbersAsString.split(",")) {

            int input = toInt(inputString);
            rangeCheck(input);

            if (!tmp.contains(input)) {
                tmp.add(input);
            }
        }
        sizeCheck(tmp);
    }

    private void sizeCheck(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.size() != Constants.LOTTO_LENGTH) {
            System.out.println(ExceptionMessage.LENGTH.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private int toInt(String inputAsString) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputAsString);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NUMERIC.getMessage());
            throw new IllegalArgumentException(
            );
        }
    }

    private void rangeCheck(int input) throws IllegalArgumentException {
        if (input < Constants.NUMBER_RANGE_START  || input > Constants.NUMBER_RANGE_END) {
            System.out.println(ExceptionMessage.LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }
}
