package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WinningNumberView {

    public Lotto inputWinningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] winningNumbers = inputStringParsing(input);

        validateWinningNumber(winningNumbers);
        List<Integer> winningNumberList = makeWinningNumberList(winningNumbers);

        checkDuplicate(winningNumberList);
        Collections.sort(winningNumberList);
        Lotto winningLotto = new Lotto(winningNumberList);
        return winningLotto;
    }

    private List<Integer> makeWinningNumberList(String[] winningNumbers) {

        List<Integer> winningNumberList = new LinkedList<>();
        int transformedWinningNumber;

        for (String winningNumber : winningNumbers) {
            transformedWinningNumber = Integer.valueOf(winningNumber);
            checkRangeWinningNumber(transformedWinningNumber);
            winningNumberList.add(transformedWinningNumber);
        }

        return winningNumberList;
    }

    private void checkRangeWinningNumber(int transformedWinningNumber) {

        if (transformedWinningNumber < 1 || transformedWinningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    public String[] inputStringParsing(String input) {

        String[] inputStrings = input.split(",");
        String[] winningNumbers = deleteBlank(inputStrings);

        return winningNumbers;
    }

    public void validateWinningNumber(String[] winningNumbers) {

        checkLength(winningNumbers);
        for (String winningNumber : winningNumbers) {
            checkNumber(winningNumber);
        }
    }

    private void checkDuplicate(List<Integer> winningNumbersList) {
        for (int index = 0; index < winningNumbersList.size() - 1; index++) {
            int operand = winningNumbersList.get(index);
            compareOtherOperand(winningNumbersList, index, operand);
        }
    }

    private void compareOtherOperand(List<Integer> numbers, int index, int operand) {

        for (int compareIndex = index + 1; compareIndex < numbers.size(); compareIndex++) {
            if (numbers.get(index) == numbers.get(compareIndex)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되어서는 안됩니다.");
            }
        }
    }

    private void checkNumber(String winningNumbers) {

        char winningNumber;
        for (int index = 0; index < winningNumbers.length(); index++) {
            winningNumber = winningNumbers.charAt(index);
            if (winningNumber < '0' || winningNumber > '9') {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public String[] deleteBlank(String[] inputStrings) {

        for (int index = 0; index < inputStrings.length; index++) {
            inputStrings[index] = inputStrings[index].trim();
        }

        return inputStrings;
    }

    private void checkLength(String[] winningNumbers) {

        if (winningNumbers == null) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개 입니다. , 을 사용하여 당첨번호를 입력해주세요.");
        }
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개 입니다. , 을 사용하여 당첨번호를 입력해주세요.");
        }
    }

    public int inputBonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {

        bonusNumberIntegerCheck(bonusNumber);
        bonusNumberRangeCheck(bonusNumber);
    }

    private void bonusNumberRangeCheck(String bonusNumber) {

        int transformedBonusNumber = Integer.parseInt(bonusNumber);

        if (transformedBonusNumber < 1 || transformedBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자 하나만 입력해야합니다.");
        }
    }

    public void bonusNumberIntegerCheck(String bonusNumber) {

        if (bonusNumber == "") {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자 하나만 입력해야합니다.");
        }
        for (int index = 0; index < bonusNumber.length(); index++) {
            if (bonusNumber.charAt(index) < '0' && bonusNumber.charAt(index) > '9') {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자 하나만 입력해야합니다.");
            }
        }
    }
}
