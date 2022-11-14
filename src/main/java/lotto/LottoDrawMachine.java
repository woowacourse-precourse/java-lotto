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


    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoDrawMachine() {
        winningNumbers = createWinningNumbers();
    }

    private Lotto createWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        throwException(input);
        List<String> numbersOfString = Arrays.asList(input.split(","));
        return (new Lotto(convertStringListToIntList(numbersOfString, Integer::parseInt)));
    }

    private void throwException(String str) {
        areNotDigitOrComma(str);
        existsEmptyValue(str);
    }

    private void areNotDigitOrComma(String str) {
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

    private void existsEmptyValue(String str) {
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
}
