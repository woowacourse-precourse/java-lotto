package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoDrawMachine {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private Lotto winningNumbers;
    private final int bonusNumber;

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoDrawMachine() throws IllegalArgumentException {
        winningNumbers = createWinningNumbers();
        bonusNumber = createBonusNumber();
    }

    private Lotto createWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        throwExceptionWinningNumbers(input);
        List<String> numbersOfString = Arrays.asList(input.split(","));
        return (new Lotto(convertStringListToIntList(numbersOfString, Integer::parseInt)));
    }

    private void throwExceptionWinningNumbers(String str) throws IllegalArgumentException {
        areNotDigitOrComma(str);
        existsEmptyValue(str);
    }

    private void areNotDigitOrComma(String str) throws IllegalArgumentException {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!Character.isDigit(ch) && !isComma(ch)) {
                throw new IllegalArgumentException("[ERROR]: 당첨 번호는 숫자와 ','만 입력이 가능홥니다.");
            }
        }
    }

    private boolean isComma(char ch) {
        return ch == ',';
    }

    private void existsEmptyValue(String str) throws IllegalArgumentException {
        boolean commaFlag = true;
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (commaFlag && isComma(ch)) {
                throw new IllegalArgumentException("[ERROR]: ',' 사이 빈 공간이 존재합니다.");
            }
            commaFlag = isComma(ch);
        }
    }

    private static <String, Integer> List<Integer>
    convertStringListToIntList(List<String> listOfString,
            Function<String, Integer> function) {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    private int createBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String str) throws IllegalArgumentException {
        isNotAllDigit(str);
        isEmptyNumber(str);
        Integer number = Integer.parseInt(str);
        isNotRange(number);
        duplicateWinningNumbers(number);
    }

    private void isNotAllDigit(String str) throws IllegalArgumentException {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1개의 숫자만 입력 가능합니다.");
            }
        }
    }

    private void isEmptyNumber(String str) throws IllegalArgumentException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("[ERROR]: 빈 값은 들어올 수 없습니다.");
        }
    }

    private void isNotRange(Integer number) throws IllegalArgumentException {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("[ERROR]: 숫자의 범위는 1 ~ 45까지여야 합니다.");
        }
    }

    private void duplicateWinningNumbers(Integer number) throws IllegalArgumentException {
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

}
