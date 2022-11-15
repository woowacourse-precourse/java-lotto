package lotto.console;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class In {
    public static Integer readPaymentAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        Integer amount;
        try {
            amount = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return amount;
    }

    public static Integer readBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus;
        try {
            bonus = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return bonus;
    }

    public static List<Integer> readMainDraw() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> mainDraw;
        try {
            mainDraw = Arrays.stream(Console.readLine().split(",")).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("콤마(',')로 구분된 숫자만 입력해 주세요.");
        }
        return mainDraw;
    }
}
