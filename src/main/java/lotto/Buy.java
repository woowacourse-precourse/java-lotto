package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Buy {

    private static final int START_NUMBER = 1;
    private static final int FINAL_NUMBER = 45;
    private static final int NUMBER_RANGE = 6;

    public static List<Integer> autoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, FINAL_NUMBER, NUMBER_RANGE);
        return numbers;
    }

    public static int orderTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        int tickets = validate.Check.countLottoTicket(money);

        return tickets;
    }

    public static void inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumbers = Integer.parseInt(Console.readLine());
    }

    public static <T, U> List<U> transform(List<T> list,
                                           Function<T, U> function)
    {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());
    }


}
