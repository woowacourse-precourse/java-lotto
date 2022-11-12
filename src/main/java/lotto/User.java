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
            throw new IllegalArgumentException("[ERROR] 1000단위의 숫자만 입력 가능합니다.");
        }
    }

    private void validWantBuyAmountInputIsNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            System.out.println(Error.IS_NOT_NUMBER.getErrorMessage());
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String winningNumbersInput() {
        String input = readLine();
        validWinningNumbersInput(input);

        return input;
    }

    public void validWinningNumbersInput(String winningNumbersInput) {
        List<Integer> winningNumbersToList = winningNumbersToList(winningNumbersInput);
        validWinningNumbersSize(winningNumbersToList);
        validDuplicateWinningNumbers(winningNumbersToList);
        validWinningNumbersRange(winningNumbersToList);
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

    public void validWinningNumbersSize(List<Integer> winningNumbersToList) {
        if (winningNumbersToList.size() != 6) {
            System.out.println(Error.LENGTH_OVER_SIX.getErrorMessage());
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

    public void validDuplicateWinningNumbers(List<Integer> winningNumbersToList) {
        for (Integer integer : winningNumbersToList) {
            if (Collections.frequency(winningNumbersToList, integer) > 1) {
                System.out.println(Error.DUPLICATED.getErrorMessage());
                throw new IllegalArgumentException("중복된 수는 입력할수 없습니다.");
            }
        }
    }

    public void validWinningNumbersRange(List<Integer> winningNumbersToList) {
        for (Integer integer : winningNumbersToList) {
            if (integer > 45 || integer < 0) {
                System.out.println(Error.RANGE_ERROR.getErrorMessage());
                throw new IllegalArgumentException("1~45 사이의 숫자만 입력 가능합니다.");
            }
        }
    }

    public int bonusNumberInput() {
        String input = readLine();
        validBonusNumberRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public void validBonusNumberInputContainWinningNumbers(int bonusNumber,List<Integer> winningNumbersToList) {
        if (winningNumbersToList.contains(bonusNumber)) {
            System.out.println(Error.DUPLICATED.getErrorMessage());
            throw new IllegalArgumentException("당첨번호에 이미 입력한 숫자는 보너스 번호로 입력할수 없습니다.");
        }
    }

    public void validBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 0) {
            System.out.println(Error.RANGE_ERROR.getErrorMessage());
            throw new IllegalArgumentException("1~45 사이의 숫자만 입력 가능합니다.");
        }
    }
}

