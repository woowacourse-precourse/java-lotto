package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static java.lang.Character.isDigit;

public class User {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private int userMoney;
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public User(int userMoney, List<Integer> winningNumbers, int bonusNumber) {

        this.userMoney = userMoney;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);

        String inputNum = Console.readLine();
        checkInteger(inputNum);

        int userMoney = Integer.parseInt(inputNum);
        checkUserMoneyUnit(userMoney);

        return userMoney;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);

        String inputNumbers = Console.readLine();
        checkWinningNumbers(inputNumbers);

        List<Integer> winningNumbers = splitNumbers(inputNumbers);
        checkWinningNumbersCount(winningNumbers);
        checkWinningNumbersDuplicate(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        String inputNumber = Console.readLine();
        checkInteger(inputNumber);

        int bonusNumber = Integer.parseInt(inputNumber);
        checkNumberRange(bonusNumber);
        checkBonusNumberDuplicate(winningNumbers, bonusNumber);

        return bonusNumber;
    }

    public List<Integer> splitNumbers(String numbers) {
        List<Integer> splitIntegerNums = new ArrayList<>();

        List<String> splitStringNums = Arrays.asList(numbers.split(","));
        for (String num : splitStringNums) {
            checkInteger(num);
            checkNumberRange(Integer.parseInt(num));
            splitIntegerNums.add(Integer.valueOf(num));
        }
        return splitIntegerNums;
    }

    public void checkInteger(String number) {
        if(!number.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void checkUserMoneyUnit(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }

    public void checkWinningNumbers(String inputNumbers) {
        for (char c : inputNumbers.toCharArray()) {
            if (!Character.isDigit(c)) {
                checkComma(c);
            }
        }
    }

    public void checkComma(char c) {
        if (c != ',') {
            throw new IllegalArgumentException("[ERROR] 쉼표를 기준으로 구분해주세요");
        }
    }

    public void checkWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수를 6개만 입력해주세요");
        }
    }

    public void checkNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위 1~45까지만 입력해주세요");
        }
    }

    public void checkWinningNumbersDuplicate(List<Integer> winningNumbers) {
        Set<Integer> notDuplicateWinningNumbers = new HashSet<>(winningNumbers);

        if (notDuplicateWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 중복되지 않게 당첨 번호를 입력해주세요");
        }
    }

    public void checkBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 서로 중복되지 않게 보너스 번호를 입력해주세요");
        }
    }
}
