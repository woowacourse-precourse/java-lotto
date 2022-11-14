package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = getPurchasePrice(Console.readLine());
        List<Integer> winningLottoNumbers = getWinningLottoNumbers(Console.readLine());
        int bonusNumber = getBonusNumber(Console.readLine(),winningLottoNumbers);

    }

    public static int getPurchasePrice(String input){
        validatePurchasePrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningLottoNumbers(String input){
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String inputNumber : inputNumbers){
            validateNumber(inputNumber);
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }

    public static int getBonusNumber(String input, List<Integer> winningLottoNumbers){
        validateNumber(input,winningLottoNumbers);
        return Integer.parseInt(input);
    }

    public static void validatePurchasePrice(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
    }

    public static void validateNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
        }
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
        }
    }

    public static void validateNumber(String input, List<Integer> winningLottoNumbers) {
        validateNumber(input);
        if (winningLottoNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(Error.INPUT_DUPLICATE.getMessage());
        }
    }
}
