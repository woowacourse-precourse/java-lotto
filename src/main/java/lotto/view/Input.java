package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int getYourMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<String> getAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String value = Console.readLine();

        return Stream.of(value.split(","))
            .collect(Collectors.toList());
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
