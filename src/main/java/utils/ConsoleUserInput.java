package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.valueOf;

public class ConsoleUserInput {
    private List<Integer> sixWinningNumbers = new ArrayList<>();

    public ConsoleUserInput(List<Integer> sixWinningNumbers) {
        this.sixWinningNumbers = sixWinningNumbers;
    }

    public String inputWinningNumbers(){
        String userInput = Console.readLine();
        return userInput;
    }

    public int toIntegerWithoutComma(String userInput){
        StringTokenizer winningNumbers = new StringTokenizer(userInput,",");
        Validatior.isValidNumber(Integer.valueOf(winningNumbers.nextToken()));
        return Integer.valueOf(winningNumbers.nextToken());
    }

    public List<Integer> putSixNumbersInRow(int winningNumbers){
        sixWinningNumbers.add(winningNumbers);
        return sixWinningNumbers;
    }

}
