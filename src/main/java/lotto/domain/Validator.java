package lotto.domain;

import lotto.view.IOProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean amountUnitIsValid(String userInput, int unit) {
        isNumber(userInput);
        int amount = Integer.parseInt(userInput);
        if(amount % unit != 0) {
            IOProcessor.printErrorMessage("구매금액의 단위가 " + unit + "원이 아닙니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static List<Integer> winningNumberIsValid(String userInput) {
        String[] numbers = winningNumberFormatIsValid(userInput);
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        for(int number : winningNumbers) {
            if(!isValidRange(number, 1, 45)) {
                IOProcessor.printErrorMessage("당첨번호 값의 범위가 올바르지 않습니다.");
                throw new IllegalArgumentException();
            }
        }
        return eachNumberIsUnique(winningNumbers);
    }

    public static int bonusNumberIsValid(String userInput, List<Integer> winningNumber) {
        isNumber(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        if(!isValidRange(bonusNumber, 1, 45)) {
            IOProcessor.printErrorMessage("입력한 값의 범위가 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
        if(winningNumber.contains(bonusNumber)) {
            IOProcessor.printErrorMessage("입력한 보너스 번호가 이미 당첨번호에 있습니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private static boolean isNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                IOProcessor.printErrorMessage("입력 내용이 숫자로 구성되어 있지 않습니다.");
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private static String[] winningNumberFormatIsValid(String userInput) {
        String[] numbers = userInput.split(",");

        if(numbers.length != 6) {
            IOProcessor.printErrorMessage("당첨번호 입력형식이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }

        for(String number : numbers) {
            isNumber(number);
        }
        return numbers;
    }

    private static boolean isValidRange(int number, int start, int end) {
        return (number >= start && number <= end);
    }

    private static List<Integer> eachNumberIsUnique(List<Integer> numbers) {
        Set<Integer> winningNumberPool = new HashSet<>();
        winningNumberPool.addAll(numbers);

        if(numbers.size() != winningNumberPool.size()) {
            IOProcessor.printErrorMessage("당첨번호는 서로 다른 6개의 수로 구성되어야 합니다.");
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}
