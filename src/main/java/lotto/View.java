package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {
    View(){

    }

    int inputMoneyAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        System.out.println();

        return money;
    }

    void printPurchasedLottoCount(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    void printPurchasedLotto(List<Integer> lottogather) {
        System.out.println(lottogather.toString());
    }

    List<Integer> inputWinningNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
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
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusnumber = Integer.parseInt(Console.readLine());
        System.out.println();

        return bonusnumber;
    }

    void printResult(int thrmatch, int fourmatch, int fivematch, int fivebonusmatch, int sixmatch, String earningrate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + thrmatch + "개");
        System.out.println("4개 일치 (50,000원) - " + fourmatch + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fivematch + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fivebonusmatch + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixmatch + "개");
        System.out.println("총 수익률은 " + earningrate + "%입니다.");
    }
}
