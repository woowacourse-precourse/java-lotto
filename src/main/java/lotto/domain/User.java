package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {

    static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액을 1000원 단위로 입력해주세요.";
    static final String COMMA_ERROR_MESSAGE = "[ERROR] 쉼표를 기준으로 구분해주세요";
    static final String WINNING_NUMBERS_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수를 6개만 입력해주세요";
    static final String WINNING_NUMBERS_RANGE_ERROR_MESSAGE = "[ERROR] 숫자 범위 1~45까지만 입력해주세요";
    static final String WINNING_NUMBERS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 서로 중복되지 않게 당첨 번호를 입력해주세요";
    static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 서로 중복되지 않게 보너스 번호를 입력해주세요";

    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int WINNING_NUMBERS_COUNT = 6;
    static final int LOTTO_PRICE = 1000;
    private List<Integer> winningNumbers;

    public int inputMoney() {
        String inputNum = Console.readLine();
        checkInteger(inputNum);

        int userMoney = Integer.parseInt(inputNum);
        checkUserMoneyUnit(userMoney);

        return userMoney;
    }

    public List<Integer> inputWinningNumbers() {
        String inputNumbers = Console.readLine();
        checkWinningNumbers(inputNumbers);

        List<Integer> winningNumbers = splitNumbers(inputNumbers);
        checkWinningNumbersCount(winningNumbers);
        checkWinningNumbersDuplicate(winningNumbers);

        this.winningNumbers = winningNumbers;
        return winningNumbers;
    }

    public int inputBonusNumber() {
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
        if (!number.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public void checkUserMoneyUnit(int userMoney) {
        if (userMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
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
            throw new IllegalArgumentException(COMMA_ERROR_MESSAGE);
        }
    }

    public void checkWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR_MESSAGE);
        }
    }

    public void checkNumberRange(int number) {
        if (number > MAX_NUM || number < MIN_NUM) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }

    public void checkWinningNumbersDuplicate(List<Integer> winningNumbers) {
        Set<Integer> notDuplicateWinningNumbers = new HashSet<>(winningNumbers);

        if (notDuplicateWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void checkBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
