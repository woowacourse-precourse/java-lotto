package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validate.Check;

import java.util.ArrayList;
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
        String money = Console.readLine();
        Check.isNumber(money);


        Long paperMoney = Long.parseLong(money);
        int tickets = Check.countLottoTicket(paperMoney);

        System.out.println("\n" + tickets + "개를 구매했습니다.");

        return tickets;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<Integer> winningNumbers = makeWinningNumbers(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumbers = Integer.parseInt(Console.readLine());
        Check.NumberDuplicate(winningNumbers, bonusNumbers);
        winningNumbers.add(bonusNumbers);

        return winningNumbers;
    }

    public static <T, U> List<U> transform(List<T> list,
                                           Function<T, U> function)
    {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static List<Integer> makeWinningNumbers(String numbers) {
        List<String> stringNumbers = new ArrayList<>();
        String removeCommaNumber = numbers.replaceAll(",", "");
        Check.isNumber(removeCommaNumber);
        
        for (int i = 0; i < removeCommaNumber.length(); i++) {
            String number = String.valueOf(removeCommaNumber.charAt(i));
            Check.NumberDuplicate(stringNumbers, number);
            stringNumbers.add(number);
        }

        Check.winningNumberSize(stringNumbers);

        List<Integer> winningNumbers = transform(stringNumbers, Integer::parseInt);

        return winningNumbers;
    }


}
