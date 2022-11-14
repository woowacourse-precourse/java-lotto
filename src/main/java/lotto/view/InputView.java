package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return new Money(money).getPay();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<String> numberList = Arrays.asList(numbers.split(","));
        return numberList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        return Integer.parseInt(number);
    }

}
