package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    SystemMessage systemMessage = new SystemMessage();
    List<Integer> winningNumbers = new ArrayList<>();

    public String inputMoney() {
        systemMessage.inputMoney();
        String inputMoney = Console.readLine();
        blankLine();
        return inputMoney;
    }

    public void validateMoney(int money) {
        if (money <= 0 || Math.floorMod(money, 1000) != 0) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int countTicket(int money) {
        int lottoPrice = 1000;
        int count = Math.floorDiv(money, lottoPrice);
        systemMessage.printCount(count);
        return count;
    }

    public List<Integer> inputWinningNumbers() {
        systemMessage.inputWinningNumbers();
        String inputNumbers = Console.readLine();
        blankLine();
        String[] numbers = inputNumbers.split(",");

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(Integer.parseInt(numbers[i]));
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        systemMessage.inputBonusNumber();
        String inputNumber = Console.readLine();
        blankLine();
        validateBonusNumber(inputNumber, winningNumbers);
        int bonusNumber = Integer.parseInt(inputNumber);
        return bonusNumber;
    }

    public void validateBonusNumber(String inputNumber, List<Integer> winningNumbers) {
        if (Integer.parseInt(inputNumber) < 1
                || Integer.parseInt(inputNumber) > 45
                || winningNumbers.contains(Integer.parseInt(inputNumber))) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void blankLine() {
        System.out.println();
    }
}