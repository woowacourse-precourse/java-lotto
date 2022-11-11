package lotto.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void inputWinningNumbers(String winningNumber) {
        stringToList(winningNumber);
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static void setBonusNumber(int bonusNumber) {
        checkBonusNumber(bonusNumber);
        Lotto.bonusNumber = bonusNumber;
    }

    private static void checkBonusNumber(int bonusNumber) {
        try{
            if(winningNumbers.contains(bonusNumber))
                throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨번호와 중복 되지 않습니다.");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void stringToList(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        convertTypeStringToInteger(numbers);
    }

    private static void convertTypeStringToInteger(List<String> numbers) {
        winningNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        checkValidation(winningNumbers);
    }

    public Lotto(List<Integer> numbers) {
        checkValidation(numbers);
        winningNumbers = numbers;
    }

    private static void checkValidation(List<Integer> numbers) {
        checkRange(numbers);
        checkLength(numbers);
        checkDuplicate(numbers);
    }

    private static void checkRange(List<Integer> numbers) {
        for(int each : numbers) {
            if(each < MIN_NUMBER || each > MAX_NUMBER) throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    private static void checkLength(List<Integer> numbers) {
        if(numbers.size() != 6) throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자의 길이는 6자리로 제한 됩니다.");
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if(temp.size() != numbers.size()) throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 겹치면 안됩니다.");
    }

}
