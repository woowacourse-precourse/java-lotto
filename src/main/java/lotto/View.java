package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {
    private static final String INPUT_AMOUNT_STRING = "구입 금액을 입력해 주세요.";
    private static final String PURCAHSED_STRING = "개를 구매했습니다.";
    private static final String INPUT_NUMBER_STRING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUM_STRING = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_STRING = "당첨 통계";
    private static final String SAME_STRING = "개 일치";
    private static final String LAST_STRING = "개";
    private static final String ERROR_TEXT = "[ERROR] : 올바른 값을 입력해주세요.";

    View(){

    }

    int inputMoneyAmount() {
        System.out.println(INPUT_AMOUNT_STRING);
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_TEXT);
        }
        System.out.println();

        return money;
    }

    void printPurchasedLottoCount(int number) {
        System.out.println(number + PURCAHSED_STRING);
    }

    void printPurchasedLotto(List<Integer> lottogather) {
        System.out.println(lottogather.toString());
    }

    List<Integer> inputWinningNum() {
        System.out.println();
        System.out.println(INPUT_NUMBER_STRING);
        String[] winningnums = Console.readLine().split(",");
        System.out.println();

        int[] winnningnumi = new int[winningnums.length];
        for(int index = 0; index < winningnums.length; index++) {
            winnningnumi[index] = Integer.parseInt(winningnums[index]);
        }

        List<Integer> result = new ArrayList<>();
        for(int element : winnningnumi) {
            result.add(element);
        }

        return result;
    }

    int inputBonusNum() {
        System.out.println(INPUT_BONUSNUM_STRING);
        int bonusnumber = Integer.parseInt(Console.readLine());
        System.out.println();

        return bonusnumber;
    }

    void printResult(int thrmatch, int fourmatch, int fivematch, int fivebonusmatch, int sixmatch, String earningrate) {
        System.out.println(STATISTICS_STRING);
        System.out.println("---");
        System.out.println(3 + SAME_STRING + " (5,000원) - " + thrmatch + LAST_STRING);
        System.out.println(4 + SAME_STRING + " (50,000원) - " + fourmatch + LAST_STRING);
        System.out.println(5 + SAME_STRING + " (1,500,000원) - " + fivematch + LAST_STRING);
        System.out.println(5 + SAME_STRING + ", 보너스 볼 일치 (30,000,000원) - " + fivebonusmatch + LAST_STRING);
        System.out.println(6 + SAME_STRING + " (2,000,000,000원) - " + sixmatch + LAST_STRING);
        System.out.println("총 수익률은 " + earningrate + "%입니다.");
    }
}
