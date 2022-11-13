package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Output {

    public static void printLotto(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto e : lotto)
            printNumbers(e);
    }

    public static void printNumbers(Lotto lotto) {
        List <Integer> numberForPrint = new ArrayList<>();
        for(int e : lotto.getNums())
            numberForPrint.add(e);
        Collections.sort(numberForPrint);
        System.out.println(numberForPrint);
    }

    public static void requestWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printEnd(Result result, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000)원 - " + result.getFifth() + "개");
        System.out.println("4개 일치 (50,000)원 - " + result.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000)원 - " + result.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000)원 - " + result.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getFirst() + "개");
        int total = result.getFifth() * 5000 + result.getFourth() * 50000 + result.getThird() * 1500000 + result.getSecond() * 30000000 + result.getFirst() * 2000000000;
        float rev = total / money;
        System.out.println("총 수익률은 " + Math.round(rev * 10) / 10.0 + "입니다.");
    }
}
