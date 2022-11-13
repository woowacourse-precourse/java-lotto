package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<String> numberList = Arrays.asList(numbers.split(","));
        return numberList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

}
