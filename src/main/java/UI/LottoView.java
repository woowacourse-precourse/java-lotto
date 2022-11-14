package UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoView {
    public static void printBuy() {
        System.out.println("구입금액을 입력해 주세요. ");
    }

    public static void printTicket(long ticket) {
        System.out.println("\n" + ticket + "개를 구매했습니다.");
    }

    public static void printUserLottoNumber(List<List<Integer>> lottoRandom, long tickets) {
        for (int i = 0; i < tickets; i++) {
            List<Integer> sortNumbers = new ArrayList<>(lottoRandom.get(i));
            Collections.sort(sortNumbers);
            System.out.println(sortNumbers);
        }
    }

    public static void inputLottoNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");

    }

    public static void winningView(int lotto1Win, int lotto2Win, int lotto3Win, int lotto4Win, int lotto5Win) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lotto5Win + "개");
        System.out.println("4개 일치 (50,000원) - " + lotto4Win + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lotto3Win + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lotto2Win + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lotto1Win + "개");
    }

    public static void printRate(double rate) {
        System.out.println("총 수익률은 " + Math.round(rate * 10) / 10.0 + "%입니다.");
    }


}
