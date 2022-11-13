package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.valueOf;

public class ConsoleUserInput {
    private List<Integer> sixWinningNumbers = new ArrayList<>();
    String userInput="nothing";

    public ConsoleUserInput() {

    }

    public static String inputWinningNumbers(){
        String userInput = Console.readLine();
        String useTrim = new String();
        userInput=useTrim.trim();
        Validator.isValidLength(userInput, 11);
        Validator.isValidFormatWithComma(userInput);
        Validator.isValidInput(userInput);
        return userInput;
    }

    public List<Integer> toIntegerNumbersWithoutComma(String userInput){
        StringTokenizer winningNumbers = new StringTokenizer(userInput,",");
        while(winningNumbers.hasMoreTokens()) {
            Validator.isInValidRange(Integer.valueOf(winningNumbers.nextToken()));
            putSixNumbersInRow(Integer.valueOf(winningNumbers.nextToken()));
        }
        return sixWinningNumbers;
    }

    public List<Integer> putSixNumbersInRow(int winningNumbers){
        sixWinningNumbers.add(winningNumbers);
        return sixWinningNumbers;
    }

    public static int inputBonusNumber(){
        String bonusNumber = Console.readLine();
        if(bonusNumber.length()>2){
            Validator.isValidLength(bonusNumber,2);
        }
        Validator.isValidInput(bonusNumber);
        Validator.isInValidRange(Integer.parseInt(bonusNumber));
        int bonus = Integer.parseInt(bonusNumber);
        return bonus;
    }

    public static int inputMoneyForLottos(){
        String moneyForLottos = Console.readLine();
        Validator.isValidUnitForPayment(moneyForLottos);
        Validator.isValidInputForPayment(moneyForLottos);
        return Integer.parseInt(moneyForLottos);
    }
}
