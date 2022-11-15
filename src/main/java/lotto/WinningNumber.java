package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    private static Lotto lotto;
    private static Exception exception;

    public List<Integer> initWinningNumber(){
        List<Integer> winningNumber = getWinningNumber();
        lotto = new Lotto(winningNumber);
        return winningNumber;
    }

    public Integer initBonusNumber(){
        String number = getBonusNumber();
        try {
            exception.checkBonusNumber(number);
            exception.checkBonusNumberRange(number);
        }catch(IllegalArgumentException e){
            throw e;
        }

        return Integer.parseInt(number);
    }

    private static List<Integer> getWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        return parsingWinningNumber(winningNumber);
    }

    private static List<Integer> parsingWinningNumber(String winningNumber){
        List<String> winningNumberList = Arrays.asList(winningNumber.split(","));
        return convertType(winningNumberList);
    }

    private static List<Integer> convertType(List<String> winningNumberList){
        List<Integer> result = winningNumberList.stream()
                .map(Integer::valueOf).collect(Collectors.toList());
        return result;
    }

    private static String getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
