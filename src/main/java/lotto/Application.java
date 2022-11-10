package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("당첨 번호를 입력해주세요");
        String numbers = Console.readLine();
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> winningNumbers = numberGenerator.createWinningNumbers(numbers);
        System.out.println(winningNumbers);
    }
}
