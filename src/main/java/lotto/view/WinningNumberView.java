package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedList;
import java.util.List;

public class WinningNumberView {

    public List<Integer> inputWinningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String winningNumbers = inputStringParsing(input);
        validateWinningNumber(winningNumbers);

        List<Integer> winningNumberList = new LinkedList<>();
        for (int index = 0; index < winningNumbers.length(); index++) {
            winningNumberList.add(Integer.valueOf(winningNumbers.charAt(index)));
        }

        return winningNumberList;
    }

    private String inputStringParsing(String input) {

        String[] inputStrings = input.split(",");
        String[] winningNumbers = deleteBlank(inputStrings);
        StringBuilder stringBuilder = new StringBuilder();

        for (String winningNumber : winningNumbers) {
            stringBuilder.append(winningNumber);
        }

        return stringBuilder.toString();
    }

    public void validateWinningNumber(String winningNumbers) {

        checkLength(winningNumbers);
        checkNumber(winningNumbers);
        checkDuplicate(winningNumbers);
    }

    private void checkDuplicate(String winningNumbers) {

        char winningNumber;

        for (int index = 0; index < winningNumbers.length(); index++) {
            winningNumber = winningNumbers.charAt(index);
            if (winningNumbers.contains(String.valueOf(winningNumber))) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되어서는 안됩니다");
            }
        }
    }

    private void checkNumber(String winningNumbers) {

        char winningNumber;
        for (int index = 0; index < winningNumbers.length(); index++) {
            winningNumber = winningNumbers.charAt(index);
            if (winningNumber < '1' || winningNumber > '9') {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1~9사이여야 합니다");
            }
        }
    }

    public String[] deleteBlank(String[] inputStrings) {

        for (int index = 0; index < inputStrings.length; index++) {
            inputStrings[index] = inputStrings[index].trim();
        }

        return inputStrings;
    }

    private void checkLength(String winningNumbers) {

        if (winningNumbers.length() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개 입니다. , 을 사용하여 당첨번호를 나눠주세요.");
        }
    }

    public int inputBonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return 0;
    }
}
