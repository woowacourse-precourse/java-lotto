package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String INPUT_PURCHASE_NUMBER = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // 구입 금액
    public int getPurchaseAmount() {
        String input = getUserInput(INPUT_PURCHASE_NUMBER);
        System.out.println("");
        return validDate(input);
    }
    public int getBonusNumber() {
        String input = getUserInput(INPUT_BONUS_NUMBER);
        System.out.println("");
        return validDate(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = getUserInput(INPUT_WINNING_NUMBER);
        System.out.println("");
        return validSplitDate(input);
    }

    private String getUserInput(String output) {
        System.out.println(output); // 상수로 변경하여 문자 출력
        return Console.readLine();
    }

    private int validDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주셔야 합니다.");
        }
    }

    private List<Integer> validSplitDate(String input) {
        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
