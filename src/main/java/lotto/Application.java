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
        lotteryValidationCheck(winnings);

        return winnings;
    }

    public static void lotteryValidationCheck(List<Integer> lotteryNumbers){
        for(Integer i : lotteryNumbers){
            if(i < 1 || i > 45)
                throw new IllegalArgumentException("[ERROR] 숫자는 1 ~ 45 중 하나의 숫자여야 합니다.");
        }
        if(lotteryNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 숫자는 6개 이어야 합니다.");
    }
}
