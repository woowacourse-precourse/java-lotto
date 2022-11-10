package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String inputWinningNumber = "당첨 번호를 입력해 주세요";
    private static final String inputBonusNumber = "보너스 번호를 입력해 주세요";

    public List<Integer> initWinningNumber(){
        List<String> winningNumber = getWinningNumber();
        winningNumber.add(getBonusNumber());
        List<Integer> winningNumbers = stringToIntegerList(winningNumber);
        return winningNumbers;
    }

    private List<String> getWinningNumber(){
        System.out.println(inputWinningNumber);
        String winningNumber = Console.readLine();
        return parsingWinningNumber(winningNumber);
    }

    private List<String> parsingWinningNumber(String winningNumber){
        String parsedWinningNumber = winningNumber.replaceAll(" ", "");
        List<String> winningNumberList = Arrays.asList(parsedWinningNumber.split(","));
        return winningNumberList;
    }

    private String getBonusNumber(){
        System.out.println(inputBonusNumber);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    private List<Integer> stringToIntegerList(List<String> winningNumbers){
        List<Integer> list = winningNumbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return list;
    }
}
