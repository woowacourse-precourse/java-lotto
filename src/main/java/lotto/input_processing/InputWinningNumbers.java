package lotto.input_processing;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserInputException;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    static UserInputException userInputException = new UserInputException();

    public InputWinningNumbers(){}

    /** 당첨 번호를 입력받는 기능 */
    public static List<Integer> getWinningNumbers() {
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
}
