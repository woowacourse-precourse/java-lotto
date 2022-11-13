package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int getYourMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        // 예외처리 필요. 1000 단위로 나눠떨어지는지, 음수는 아닌지
        return Integer.parseInt(Console.readLine());
    }

    public static List<String> getAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // 예외처리 필요 1~45숫자의 사이가 맞는지, 6개가 맞는지.
        String value = Console.readLine();

        return Stream.of(value.split(","))
            .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        // 예외처리 필요 1~45가 맞는지
        return Integer.parseInt(Console.readLine());
    }
}
