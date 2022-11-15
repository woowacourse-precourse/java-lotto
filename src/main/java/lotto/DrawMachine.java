package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class DrawMachine {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public void drawNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        validate(userInput);
        System.out.println();

        for (String number : userInput.split(",")) {
            winningNumbers.add(Integer.valueOf(number));
        }
        validate(winningNumbers);
    }

    private void validate(String winningNumbers) {
        if (!Pattern.matches("^[0-9,]+$", winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자 및 쉼표(,)로만 이루어져 있어야 합니다.");
        }
        if (!Pattern.matches("^[0-9]+(,[0-9]+){5}$", winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)는 숫자 사이에만 존재할 수 있습니다.");
        }
    }

    private void validate(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 각 숫자들은 1~45의 값이어야 합니다.");
            }
        }
        if (new HashSet<>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    public void drawBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        validateBonusNumber(userInput);
        System.out.println();

        bonusNumber = Integer.parseInt(userInput);
    }

    private void validateBonusNumber(String userInput) {
        if (!Pattern.matches("^[0-9]+$", userInput)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해야 합니다.");
        }
        int bonusNumber = Integer.parseInt(userInput);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45의 값이어야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 존재하지 않아야 합니다.");
        }
    }
}
