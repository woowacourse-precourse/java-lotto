package lotto;

import utils.ConsoleUserInput;
import utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ConsoleUserInput in = new ConsoleUserInput();
        validate(numbers);
        Validator.hasNoDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static String validateMoneyForLottos(String moneyForLottos){
        Validator.tryAndCatchIsValidInputForPayment(moneyForLottos);
        Validator.tryAndCatchIsValidUnitForPayment(moneyForLottos);
        Validator.tryAndCatchHasNoMoney(moneyForLottos);
        return moneyForLottos;
    }

    public static int ToIntegerMoneyForCalculation(String moneyForLottos){
        return Integer.parseInt(moneyForLottos);
    }

    public static String validateWinningNumbers(String userInput){
        userInput=userInput.trim();
        userInput=userInput.replaceAll(" ","");
        Validator.tryAndCatchIsValidLength(userInput, 18);
        Validator.tryAndCatchIsValidFormatWithComma(userInput);
        return userInput;
    }

    public static List<Integer> toIntegerNumbersWithoutComma(String userInput){
        List<Integer> sixWinningNumbers = new ArrayList<>();
        String[] numbersToStringsForValidation = userInput.split(",");
        for(int index=0; index<numbersToStringsForValidation.length; index++) {
            Validator.tryAndCatchIsInValidRange(Integer.parseInt(numbersToStringsForValidation[index]));
        }
        for(int index=0; index<numbersToStringsForValidation.length; index++) {
            sixWinningNumbers.add(Integer.valueOf(numbersToStringsForValidation[index]));
        }
        Validator.tryAndCatchHasNoDuplication(sixWinningNumbers);
        return sixWinningNumbers;
    }

    public static String validateBonusNumber(String bonusNumber, List<Integer> winningNumbers){
        if(bonusNumber.length()>2){
            Validator.tryAndCatchIsValidLength(bonusNumber,2);
        }
        Validator.tryAndCatchIsValidInput(bonusNumber);
        Validator.tryAndCatchIsInValidRange(Integer.parseInt(bonusNumber));
        int bonus = Integer.parseInt(bonusNumber);
        Validator.tryAndCatchIsBonusDifferentWithWinningNumbers(winningNumbers, bonus);
        return bonusNumber;
    }

    public static int getBonusNumber(String bonusNumber){
        int bonus = Integer.parseInt(bonusNumber);
        return bonus;
    }

}