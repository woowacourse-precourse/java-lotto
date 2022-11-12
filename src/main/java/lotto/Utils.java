package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {
    SystemMessage systemMessage = new SystemMessage();
    List<Integer> winningNumbers = new ArrayList<>();

    public int inputMoney() {
        systemMessage.inputMoney();
        String inputMoney = Console.readLine();
        blankLine();
        validateMoney(inputMoney);
        int money = Integer.parseInt(inputMoney);
        return money;
    }

    private void blankLine() {
        System.out.println();
    }

    public void validateMoney(String inputMoney) {
        if (!Pattern.matches("[0-9]+", inputMoney)
                || Integer.parseInt(inputMoney) <= 0
                || Math.floorMod(Integer.parseInt(inputMoney), 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 입력이 가능합니다.");
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
        validateInputNumbers(inputNumbers);
        String[] numbers = inputNumbers.split(",");

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(Integer.parseInt(numbers[i]));
        }

        return winningNumbers;
    }

    public void validateInputNumbers(String inputNumbers) {
        if (!Pattern.matches("[0-9]+", inputNumbers.replaceAll(",", ""))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
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
        if (!Pattern.matches("[0-9]+", inputNumber)
                || Integer.parseInt(inputNumber) < 1
                || Integer.parseInt(inputNumber) > 45
                || winningNumbers.contains(Integer.parseInt(inputNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}