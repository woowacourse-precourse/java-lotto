package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.Input;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Input inputValues() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = Integer.parseInt(Console.readLine());
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumbers = Arrays.asList(Console.readLine().split(","));
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        Input input = new Input(purchaseMoney, winningNumbers, bonusNumber);
    }

    private static int inputWinningNumber

}
