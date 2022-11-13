package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public List<Integer> initWinningNumber(){
        List<Integer> winningNumber = getWinningNumber();
        return winningNumber;
    }

    public Integer initBonusNumber(){
        return getBonusNumber();
    }

    private static List<Integer> getWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        return parsingWinningNumber(winningNumber);
    }

    private static List<Integer> parsingWinningNumber(String winningNumber){
        String parsedWinningNumber = winningNumber.replaceAll(" ", "");
        List<String> winningNumberList = Arrays.asList(parsedWinningNumber.split(","));
        return convertType(winningNumberList);
    }

    private static List<Integer> convertType(List<String> winningNumberList){
        List<Integer> result = winningNumberList.stream()
                .map(Integer::valueOf).collect(Collectors.toList());
        return result;
    }

    private static Integer getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

}
