package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 공백을 제외한 숫자를 입력해 주세요.");
        }
        return new Money(money).getPay();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<String> numberList = Arrays.asList(numbers.split(","));
        return convertIntList(numberList);

    }

    private static List<Integer> convertIntList(List<String> numberList) {
        List<Integer> numbers;
        try {
            numbers = numberList.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구분자(,)로만 구분된 숫자를 입력해 주세요. ex) 1,2,3,4,5,6");
        }
        return numbers;
    }

    public static int inputBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 공백을 제외한 숫자를 입력해 주세요.");
        }
        return new Bonus(number, winningNumbers.getNumbers()).getNumber();
    }

}
