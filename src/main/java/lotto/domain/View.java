package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String inputPrint() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void countPrint(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static String numbersPrint() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusPrint() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void reportPrint(Integer[] winningCount, double returnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningCount[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount[5] + "개");
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
