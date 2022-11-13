package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    enum NumberType { WINNING, BONUS, NORMAL };

    public static void guideWinningNumberFormat() { System.out.print("당첨 번호 6개를 쉼표로 구분해 입력해주세요: "); }

    public static void isVoidInput(String numberInput) {
        if (numberInput.length() == 0)
            throw new IllegalArgumentException("문자를 입력하십시오.");
    }

    public static boolean isComma(char charAtIndex) { return charAtIndex == ','; }
    public static boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    public static void isInputCommaAndNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
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

    public static void checkRange(List<Integer> numbers) {
        for (int number : numbers)
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

    public static NumberType[] checkNumberTypeByIndex(List<Integer> winningNumbers) {
        NumberType[] numberTypeCheck = new NumberType[46];
        for (int number = 1; number <= 45; number++)
            numberTypeCheck[number] = NumberType.NORMAL;
        for (int number : winningNumbers)
            numberTypeCheck[number] = NumberType.WINNING;
        return numberTypeCheck;
    }

    public static NumberType[] getWinningNumbers() {
        guideWinningNumberFormat();
        String winningNumberInput = Console.readLine();

        isVoidInput(winningNumberInput);
        isInputCommaAndNumber(winningNumberInput);

        String[] splitNumbers = winningNumberInput.split(",");
        hasSixNumbers(splitNumbers);

        List<Integer> winningNumbers = parseNumbers(splitNumbers);
        checkRange(winningNumbers);
        isDuplicated(winningNumbers);
        return checkNumberTypeByIndex(winningNumbers);
    }

    public static void guideBonusNumberFormat() {
        System.out.print("당첨 번호가 아닌 1이상 45이하의 숫자를 보너스 번호로 입력해주세요: ");
    }

    public static void isInputNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static void isDuplicatedWithWinningNumbers(NumberType[] numberTypeCheck, List<Integer> bonusNumber) {
        int bonus = bonusNumber.get(0);
        if(numberTypeCheck[bonus] == NumberType.WINNING)
            throw new IllegalArgumentException("당첨번호가 아닌 다른 보너스 번호를 입력하십시오.");
    }

    public static NumberType[] getBonusNumber(NumberType[] numberTypeCheck) {
        guideBonusNumberFormat();
        String bonusNumberInput = Console.readLine();

        isVoidInput(bonusNumberInput);
        isInputNumber(bonusNumberInput);

        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(Integer.parseInt(bonusNumberInput));
        checkRange(bonusNumber);
        isDuplicatedWithWinningNumbers(numberTypeCheck, bonusNumber);
        numberTypeCheck[bonusNumber.get(0)] = NumberType.BONUS;
        return numberTypeCheck;
    }

        public static void main(String[] args) {
        NumberType[] numberTypeCheck = getWinningNumbers();
        numberTypeCheck = getBonusNumber(numberTypeCheck);
    }
}