package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class InputDriver {
    public int inputBuyingAmount() {
        String buyingAmountString = Console.readLine();
        ExceptionCase exceptionCase = new ExceptionCase();

        exceptionCase.checkIfAmountInputIsInteger(buyingAmountString);
        exceptionCase.checkIf1000Unit(buyingAmountString);


        int buyingAmount = Integer.parseInt(buyingAmountString);
        return buyingAmount;
    }
    public int[] inputNumbers() {
        ExceptionCase exceptionCase = new ExceptionCase();
        new PrintDriver().printInputNumbersMessage();
        String inputNumbersString = Console.readLine();
        int[] inputNumbersArray = new int[inputNumbersString.split(",").length];
        int index = 0;
        for (String inputNumbers : inputNumbersString.split(",")){

            inputNumbersArray[index++] = exceptionCase.checkIfNumberInRightFormat(inputNumbers);

        }
        return inputNumbersArray;
    }
    public int inputBonusNumber(List<Integer> numbers) {
        ExceptionCase exceptionCase = new ExceptionCase();
        new PrintDriver().printInputBonusNumberMessage();
        String inputBonusNumberString = Console.readLine();
        int bonusNumber;

        exceptionCase.validationOfInput(inputBonusNumberString);
        bonusNumber = Integer.parseInt(inputBonusNumberString);
        exceptionCase.validationForNumber(numbers, bonusNumber);
        exceptionCase.validationForRange(bonusNumber);

        return Integer.parseInt(inputBonusNumberString);
    }





}
