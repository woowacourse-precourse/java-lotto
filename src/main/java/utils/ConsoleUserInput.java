package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUserInput {
    // 입력부 제외 유효성 체크 완전히 빼서 lotto 내 메서드로 구현

    public String inputWinningNumbers(){
        String userInput = Console.readLine();
        userInput=userInput.trim();
        userInput=userInput.replaceAll(" ","");
        validateWinningNumbers(userInput);
        return userInput;
    }

    public void validateWinningNumbers(String userInput){
        Validator.tryAndCatchIsValidLength(userInput, 18);
        Validator.tryAndCatchIsValidFormatWithComma(userInput);
    }

    public List<Integer> toIntegerNumbersWithoutComma(String userInput){
        List<Integer> sixWinningNumbers = new ArrayList<>();
        String[] numbersToStringsForValidation = userInput.split(",");
        for(int index=0; index<numbersToStringsForValidation.length; index++) {
            Validator.tryAndCatchIsInValidRange(Integer.valueOf(numbersToStringsForValidation[index]));
        }
        for(int index=0; index<numbersToStringsForValidation.length; index++) {
            sixWinningNumbers.add(Integer.valueOf(numbersToStringsForValidation[index]));
        }
        Validator.tryAndCatchHasNoDuplication(sixWinningNumbers);
        return sixWinningNumbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers){
        String bonusNumber = Console.readLine();
        if(bonusNumber.length()>2){
            Validator.tryAndCatchIsValidLength(bonusNumber,2);
        }
        Validator.tryAndCatchIsValidInput(bonusNumber);
        Validator.tryAndCatchIsInValidRange(Integer.parseInt(bonusNumber));
        int bonus = Integer.parseInt(bonusNumber);
        Validator.tryAndCatchIsBonusDifferentWithWinningNumbers(winningNumbers, bonus);
        return bonus;
    }

    public static int inputMoneyForLottos(){
        String moneyForLottos = Console.readLine();
        Validator.tryAndCatchIsValidInputForPayment(moneyForLottos);
        Validator.tryAndCatchIsValidUnitForPayment(moneyForLottos);
        Validator.tryAndCatchHasNoMoney(moneyForLottos);
        return Integer.parseInt(moneyForLottos);
    }
}
