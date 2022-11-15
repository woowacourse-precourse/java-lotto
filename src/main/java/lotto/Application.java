package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int validatePayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = readLine();
        if (Integer.parseInt(payment) % 1000 != 0) {
            System.out.println("[ERROR] 유효한 구입금액이 아닙니다.");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(payment) / 1000;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = readLine();
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int number: winningNumbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        return winningNumbers;
    }

    public static void main(String[] args) {
        int payment = validatePayment();
        List<Integer> winningNumbers = getWinningNumbers();
    }
}
