package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    static UserInputException userInputException = new UserInputException();

    InputWinningNumbers(){}

    /** 당첨 번호 입력 및 예외처리 기능 */
    static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        if (!userInputException.checkWinningNumberSize(input.length))
            throw new IllegalArgumentException("[ERROR]");

        List<Integer> result = new ArrayList<>();
        for (int i=0;i<input.length;i++) {
            if (!userInputException.checkInputTypeAndRange(input[i]))
                throw new IllegalArgumentException("[ERROR]");
            result.add(Integer.valueOf(input[i]));
        }
        return result;
    }

    /** 보너스 번호 입력 및 예외처리 기능 */
     static int getBonusNumbers(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!userInputException.checkInputTypeAndRange(input))
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력값이 잘못되었습니다.");
        if(winningNumbers.contains(Integer.valueOf(input))){
            throw new IllegalArgumentException("[ERROR] 당첨번호에 이미 존재하는 숫자입니다.");
        }

        return Integer.valueOf(input);
    }
}
