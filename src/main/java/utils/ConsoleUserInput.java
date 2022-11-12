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

    public String inputWinningNumbers(){
        String userInput = Console.readLine();
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
}
