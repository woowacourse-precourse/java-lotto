package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUI {
    public static Integer purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        final String input = Console.readLine();
        numericValidate(input);
        return Integer.parseInt(input);
    }

    public static void numberOfLottoPurchased(final int num) {
        System.out.printf("%d개를 구매했습니다.\n", num);
    }

    public static void printLotto(final Lotto lotto) {
        List<Integer> sortedNumbers = lotto.getNumbers().stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public static void WinStatisticTitle() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinHistory(final Integer machNumber, final Integer prizeMoney, final Integer winAmount) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", machNumber, prizeMoney, winAmount);
    }

    public static void printWinHistoryWithBonus(final Integer machNumber, final Integer prizeMoney, final Integer winAmount) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", machNumber, prizeMoney, winAmount);
    }

    public static List<Integer> receiveWinNumbers() {
        System.out.println("당첨번호를 입력해 주세요.");
        final String input = Console.readLine();
        String[] splitInput = input.split(",");

        amountValidate(splitInput);

        List<Integer> winNumbers = new ArrayList<>();
        for (String num : splitInput) {
            numericValidate(num);
            Integer number = Integer.parseInt(num);
            lottoNumberRangeValidate(number);
            winNumbers.add(number);
        }

        return winNumbers;
    }

    public static Integer receiveBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        final String input = Console.readLine();
        numericValidate(input);
        Integer number = Integer.parseInt(input);
        lottoNumberRangeValidate(number);
        return number;
    }

    public static void printBenefit(double benefit) {
        benefit *= 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", benefit);
    }

    private static <T> void amountValidate(T[] target) {
        if (target.length != LottoEnum.WINNING_NUMBERS.getValue()) {
            System.out.println("[ERROR] 쉼표 구분자를 정확히 입력해주세요.");
            throw new IllegalArgumentException(String.format("[ERROR] 쉼표 구분자를 정확히 입력해주세요."));
        }
    }

    private static void numericValidate(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자로 변환할 수 없는 입력입니다.");
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 입력입니다.");
        }
    }

    private static void lottoNumberRangeValidate(Integer num) {
        if (num < LottoEnum.MIN_NUMBER.getValue() || num > LottoEnum.MAX_NUMBER.getValue()) {
            System.out.println("[ERROR] 로또 번호 범위 밖의 숫자입니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위 밖의 숫자입니다.");
        }
    }
}