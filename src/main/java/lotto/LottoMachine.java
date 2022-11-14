package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validate.Check;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int START_NUMBER = 1;
    private static final int FINAL_NUMBER = 45;
    private static final int NUMBER_RANGE = 6;

    public static List<Integer> autoNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(START_NUMBER, FINAL_NUMBER, NUMBER_RANGE));
        numbers.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(numbers);
    }

    public static int orderTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        int tickets;
        try {
            Check.isNumber(money);
            Long paperMoney = Long.parseLong(money);
            tickets = Check.countLottoTicket(paperMoney);

            System.out.println("\n" + tickets + "개를 구매했습니다.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return orderTicket();
        }


        return tickets;


    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<Integer> winningNumbers;
        try {
            List<String> temporaryWinningNumbers = Arrays.asList(numbers.split(","));
            Check.isNumber(temporaryWinningNumbers);
            Check.rightRange(temporaryWinningNumbers, START_NUMBER, FINAL_NUMBER);
            Check.numberDuplicate(temporaryWinningNumbers);
            Check.winningNumberCount(temporaryWinningNumbers);

            winningNumbers = convertIntNumbers(temporaryWinningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }

        return winningNumbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumbers = Console.readLine();
        int bonusNumber;
        try {
            List<String> temporaryBonusNumbers = Arrays.asList(bonusNumbers.split(","));
            Check.bonusNumberCount(temporaryBonusNumbers);
            Check.isNumber(temporaryBonusNumbers);
            Check.rightRange(temporaryBonusNumbers, START_NUMBER, FINAL_NUMBER);

            bonusNumber = Integer.parseInt(temporaryBonusNumbers.get(0));
            Check.numberDuplicate(winningNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }


    public static List<Integer> convertIntNumbers(List<String> temporaryNumbers) {
        List<Integer> intNumbers;

        intNumbers = temporaryNumbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return intNumbers;
    }


}
