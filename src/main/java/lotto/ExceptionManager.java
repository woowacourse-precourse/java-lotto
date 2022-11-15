package lotto;

import java.util.ArrayList;
import java.util.List;

public class ExceptionManager {

    public void checkPlayerMoney(String playerMoney) {
        checkStringInputException(playerMoney);
        checkBlankInputException(playerMoney);
        checkMoneyInputException(playerMoney);
    }

    public void checkWinningNumbers(List<String> numbers) {
        List<Integer> intNumbers = new ArrayList<>();
        checkSixNumbersInput(numbers);
        checkDuplicateInputException(numbers);
        for (String index : numbers) {
            checkStringInputException(index);
            checkBlankInputException(index);
        }
        for (int i = 0; i < numbers.size(); i++) {
            intNumbers.add(Integer.parseInt(numbers.get(i)));
            checkNumbersOutOfRange(intNumbers, i);
        }
    }

    public void checkBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        int parsedNumber = Integer.parseInt(bonusNumber);
        checkBlankInputException(bonusNumber);
        checkStringInputException(bonusNumber);
        if (winningNumbers.contains(parsedNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.");
        }
        if (parsedNumber > 45 || parsedNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 1이상 45 이하의 숫자만 입력할 수 있습니다.");
        }
    }

    private void checkMoneyInputException(String playerMoney) {
        int inputMoney = Integer.parseInt(playerMoney);
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 넣어주시기 바랍니다.");
        }
    }

    private void checkBlankInputException(String playerMoney) {
        if (playerMoney.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    private void checkStringInputException(String playerMoney) {
        try {
            Integer.parseInt(playerMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력할 수 없습니다.");
        }
    }

    private void checkSixNumbersInput(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해야 합니다.");
        }
    }

    private void checkDuplicateInputException(List<String> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private void checkNumbersOutOfRange(List<Integer> numbers, int i) {
        if (numbers.get(i) > 45 || numbers.get(i) < 1) {
            throw new IllegalArgumentException("[ERROR] 1이상 45 이하의 숫자만 입력할 수 있습니다.");
        }
    }
}
