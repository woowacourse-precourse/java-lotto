package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String DIVISION_CHAR = ",";
    private static final Integer PURCHASE_UNIT = 1000;

    public Integer purchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userInput = Console.readLine();
        if (userInput.matches(".*[a-zA-Z]+.*")) {
            System.out.println("[ERROR] 숫자만 입력할래?");
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하거라");
        }
        Integer input = Integer.parseInt(userInput);
        if (input % PURCHASE_UNIT > 0) {
            throw new IllegalArgumentException("1000원 단위로만 구매 가능합니다.");
        }
        return input / PURCHASE_UNIT;

    }


    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String input = Console.readLine();
        return Arrays.stream(input.split(DIVISION_CHAR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    //예외 처리 필요합니다.

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }
    // 예외 처리 필요합니다.


}