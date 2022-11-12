package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validate.Check;

import java.util.Arrays;
import java.util.List;
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
        String temporaryBonusNumbers = Console.readLine();
        Check.isNumber(temporaryBonusNumbers);
        int bonusNumber = Integer.parseInt(temporaryBonusNumbers);
        Check.rightRange(bonusNumber, START_NUMBER, FINAL_NUMBER);
        Check.numberDuplicate(winningNumbers, bonusNumber);
        winningNumbers.add(bonusNumber);

        return winningNumbers;
    }


    public static List<Integer> makeWinningNumbers(String numbers) {
        List<String> temporaryWinningNumbers = Arrays.asList(numbers.split(","));
        Check.isNumber(temporaryWinningNumbers);
        Check.rightRange(temporaryWinningNumbers, START_NUMBER, FINAL_NUMBER);
        Check.numberDuplicate(temporaryWinningNumbers);
        Check.numberCount(temporaryWinningNumbers);

        List<Integer> winningNumbers = temporaryWinningNumbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return winningNumbers;
    }


}
