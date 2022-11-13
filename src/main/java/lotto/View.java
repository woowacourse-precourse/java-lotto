package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class View {
    int inputMoneyAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        System.out.println();

        return money;
    }

    void printPurchasedLotto(int number, int[][] lottogather) {
        System.out.println(number + "개를 구매했습니다.");

        for(int[] data : lottogather) {
            System.out.println(Arrays.toString(data));
        }
    }

    int[] inputWinningNum() {
        String[] winningnum = Console.readLine().split(",");
        System.out.println();

        int[] winningnums = new int[winningnum.length];
        for(int index = 0; index < winningnum.length; index++) {
            winningnums[index] = Integer.parseInt(winningnum[index]);
        }

        return winningnums;
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
