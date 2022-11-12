package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void guideWinningNumberFormat() {
        System.out.print("당첨 번호 6개를 쉼표로 구분해 입력해주세요: ");
    }

    public static void isVoidInput(String winningNumberInput) {
        if (winningNumberInput.length() == 0)
            throw new IllegalArgumentException("문자를 입력하십시오.");
    }

    public static boolean isComma(char charAtIndex) { return charAtIndex == ','; }
    public static boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    public static void isCommaAndNumber(String winningNumberInput) {
        int inputLength = winningNumberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = winningNumberInput.charAt(index);
            if (isComma(charAtIndex)) continue;
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static void hasSixNumbers(String[] winningNumbers) {
        if (winningNumbers.length != 6)
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분되는 6개의 수로 구성돼야 합니다.");
    }

    public static List<Integer> parseNumbers(String[] splitNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberInString : splitNumbers) {
            int numberInInteger = Integer.parseInt(numberInString);
            winningNumbers.add(numberInInteger);
        }
        return winningNumbers;
    }

    public static void checkRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers)
            if (number > 45 || number < 1)
                throw new IllegalArgumentException("당첨 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    public static void isDuplicated(List<Integer> winningNumbers) {
        boolean[] isWinningNumber = new boolean[46];
        for (int number : winningNumbers) {
            if (isWinningNumber[number])
                throw new IllegalArgumentException("당첨 번호엔 중복된 숫자가 없어야 합니다.");
            isWinningNumber[number] = true;
        }
    }
    public static boolean[] checkWinningNumberByIndex(List<Integer> winningNumbers) {
        boolean[] isWinningNumber = new boolean[46];
        for (int number : winningNumbers)
            isWinningNumber[number] = true;
        return isWinningNumber;
    }
    public static boolean[] getWinningNumbers() {
        guideWinningNumberFormat();
        String winningNumberInput = Console.readLine();

        isVoidInput(winningNumberInput);
        isCommaAndNumber(winningNumberInput);

        String[] splitNumbers = winningNumberInput.split(",");
        hasSixNumbers(splitNumbers);

        List<Integer> winningNumbers = parseNumbers(splitNumbers);
        checkRange(winningNumbers);
        isDuplicated(winningNumbers);
        return checkWinningNumberByIndex(winningNumbers);
    }

    public static void main(String[] args) {
        boolean[] isWinningNumber = getWinningNumbers();
    }
}