package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");


    public int wantBuyAmountInput() {
        String userInput = readLine();
        validWantBuyAmountInputIsNumber(userInput);
        int wantBuyAmountInput = Integer.parseInt(userInput);
        validWantByAmountInput(wantBuyAmountInput);
        return wantBuyAmountInput;
    }

    private void validWantByAmountInput(int wantBuyAmount) {
        if (wantBuyAmount % 1000 != 0) {
            System.out.println(Error.IS_NOT_THOUSANDS.getErrorMessage());
            throw new IllegalArgumentException(Error.IS_NOT_THOUSANDS.getErrorMessage());
        }
    }

    private void validWantBuyAmountInputIsNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            System.out.println(Error.IS_NOT_NUMBER.getErrorMessage());
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getErrorMessage());
        }
    }

    public String winningNumbersInput() {
        String input = readLine();
        validWinningNumbersInput(input);

        return input;
    }

    private void validWinningNumbersInput(String winningNumbersInput) {
        validWinningNumbersInputIsNumber(winningNumbersInput);
        List<Integer> winningNumbersToList = winningNumbersToList(winningNumbersInput);
        validWinningNumbersSize(winningNumbersToList);
        validDuplicateWinningNumbers(winningNumbersToList);
        validWinningNumbersRange(winningNumbersToList);
    }

    private void validWinningNumbersInputIsNumber(String winningNumbersInput) {
        for (int i = 0; i < winningNumbersInput.length(); i++) {
            if (winningNumbersInput.charAt(i) == ',') {
                continue;
            }
            if (!NUMBER_PATTERN.matcher(String.valueOf(winningNumbersInput.charAt(i))).matches()) {
                System.out.println(Error.IS_NOT_NUMBER.getErrorMessage());
                throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getErrorMessage());
            }
        }
    }

    public List<Integer> winningNumbersToList(String winningNumbersInput) {
        List<Integer> result = new ArrayList<>();
        String[] split = winningNumbersInput.split(",");

        for (String s : split) {
            result.add(Integer.parseInt(s));
        }

        Collections.sort(result);

        return result;
    }

    private void validWinningNumbersSize(List<Integer> winningNumbersToList) {
        if (winningNumbersToList.size() != 6) {
            System.out.println(Error.LENGTH_OVER_SIX.getErrorMessage());
            throw new IllegalArgumentException(Error.LENGTH_OVER_SIX.getErrorMessage());
        }
    }

    private void validDuplicateWinningNumbers(List<Integer> winningNumbersToList) {
        for (Integer integer : winningNumbersToList) {
            if (Collections.frequency(winningNumbersToList, integer) > 1) {
                System.out.println(Error.DUPLICATED.getErrorMessage());
                throw new IllegalArgumentException(Error.DUPLICATED.getErrorMessage());
            }
        }
    }

    private void validWinningNumbersRange(List<Integer> winningNumbersToList) {
        for (Integer integer : winningNumbersToList) {
            if (integer > 45 || integer < 0) {
                System.out.println(Error.RANGE_ERROR.getErrorMessage());
                throw new IllegalArgumentException(Error.RANGE_ERROR.getErrorMessage());
            }
        }
    }

    public int bonusNumberInput(List<Integer> winningNumbersToList) {
        String input = readLine();
        validBonusNumberIsNumber(input);
        validBonusNumberRange(Integer.parseInt(input));
        validBonusNumberInputContainWinningNumbers(Integer.parseInt(input),winningNumbersToList);
        return Integer.parseInt(input);
    }

    public void validBonusNumberInputContainWinningNumbers(int bonusNumber,List<Integer> winningNumbersToList) {
        if (winningNumbersToList.contains(bonusNumber)) {
            System.out.println(Error.DUPLICATED.getErrorMessage());
            throw new IllegalArgumentException(Error.DUPLICATED.getErrorMessage());
        }
    }

    private void validBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 0) {
            System.out.println(Error.RANGE_ERROR.getErrorMessage());
            throw new IllegalArgumentException(Error.RANGE_ERROR.getErrorMessage());
        }
    }

    private void validBonusNumberIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            System.out.println(Error.IS_NOT_NUMBER.getErrorMessage());
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getErrorMessage());
        }
    }
}

