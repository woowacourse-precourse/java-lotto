package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public List<String> initWinningNumber(){
        List<String> winningNumber = getWinningNumber();
        return winningNumber;
    }

    public String initBonusNumber(){
        return getBonusNumber();
    }

    private static List<String> getWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        return parsingWinningNumber(winningNumber);
    }

    private static List<String> parsingWinningNumber(String winningNumber){
        String parsedWinningNumber = winningNumber.replaceAll(" ", "");
        List<String> winningNumberList = Arrays.asList(parsedWinningNumber.split(","));
        return winningNumberList;
    }

    private static String getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

}
