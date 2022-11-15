package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Input inputValues() {
        int inputPurchaseAmount = inputPurchaseAmount();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumbers = Arrays.asList(Console.readLine().split(","));
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = parseInt(Console.readLine());
        Input input = new Input(inputPurchaseAmount, winningNumbers, bonusNumber);
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(Console.readLine());
    }

    private static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> temp = Arrays.asList(Console.readLine().split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : temp) {
            winningNumbers.add(parseInt(number));
        }
        return winningNumbers;
    }

}
