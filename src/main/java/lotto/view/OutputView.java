package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printStartMesseage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumber(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printRequestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printFifth(int count) {
        System.out.println("3개 일치 (5,000원) - " + count + "개");
    }

    public static void printFourth(int count){
        System.out.println("4개 일치 (50,000원) - " + count + "개");
    }

    public static void printThird(int count){
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");
    }

    public static void printSecond(int count){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
    }

    public static void printFirst(int count){
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
    }

    public static void printYield(float yield){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    public static void printResultMessage() {
        System.out.println("당첨 통계\n---");
    }
}
