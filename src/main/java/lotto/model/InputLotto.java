package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputLotto {

    int inputMoney() {
        String input = Console.readLine();
        validateNumber(input);
        int money = Integer.parseInt(input);
        validateDivideThousand(money);
        return money;
    }

    List<Integer> inputWinNumber() {
        String input = Console.readLine();
        return convertToWinNumbers(input);
    }

    List<Integer> convertToWinNumbers(String input) {
        List<Integer> winNumbers = new ArrayList<>(6);
        String[] splitInput = input.split(",");
        validateSeparatorAndSize(splitInput);

        for (String number : splitInput) {
            validateNumberInRange(number);
            winNumbers.add(validateDuplicateNumber(winNumbers, Integer.parseInt(number)));
        }
        return winNumbers;
    }

    int inputBonusNumber(List<Integer> winNumbers) {
        String input = Console.readLine();
        return convertToBonusNumber(input, winNumbers);
    }

    int convertToBonusNumber(String input, List<Integer> winNumbers) {
        validateNumberInRange(input);
        int bonusNumber = Integer.parseInt(input);
        validateDuplicateNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }

    void validateSeparatorAndSize(String[] input) {
        if (input.length != 6) {
            System.out.println("[ERROR] 6개의 숫자를 ',' 로 구분해 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    void validateNumberInRange(String number) {
        int convertNumber;
        try {
            convertNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        if (convertNumber < 1 | convertNumber > 45) {
            System.out.println("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    int validateDuplicateNumber(List<Integer> winNumbers, int number) {
        if (winNumbers.contains(number)) {
            System.out.println("[ERROR] 당첨 번호는 중복된 값을 가질 수 없습니다.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    void validateNumber(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    void validateDivideThousand(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1000단위의 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }
}