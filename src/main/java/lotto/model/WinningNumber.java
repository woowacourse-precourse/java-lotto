package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    public WinningNumber() {
        List<String> winningNumbers;
        // 당첨번호 입력
        String input = removeSpace(inputWinningNumbers());
        winningNumbers = Arrays.asList(input.split(","));
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        System.out.println(winningNumbers);
    }

    private static String inputWinningNumbers() {
        return Console.readLine();
    }

    private String removeSpace(String input) {
        return input.replaceAll("\\s" , "");
    }
}
