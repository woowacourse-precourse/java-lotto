package lotto;

import java.util.Collections;
import java.util.List;

public class Output {

    public static void printLotto() {
        System.out.println(Lotto.lottoQuantity + "개를 구매했습니다.");
        for (Lotto e : StartLotto.lotto)
            printNumbers(e);
    }

    public static void printNumbers(Lotto lotto) {
        List<Integer> numberForPrint = lotto.getNums();
        Collections.sort(numberForPrint);
        System.out.println(numberForPrint);
    }

    public static void requestWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printEnd() {
        float revenue = Result.getTotalPrize() / (float) StartLotto.payment;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Result.fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + Result.fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Result.third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Result.second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Result.first + "개");
        System.out.println("총 수익률은 " + Math.round(revenue * 1000) / 10.0 + "%입니다.");
    }
}
