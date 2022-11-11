package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getWinningNumbers(String userInput) throws IllegalArgumentException {
        String[] splitedInputs = userInput.trim().split(",");
        List<Integer> winnings = new ArrayList<>();
        for (String s : splitedInputs) {
            try {
                winnings.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 사이는 ,로 구분되어야 합니다.");
            }
        }

        return winnings;
    }
}
