package lotto.system;

import java.util.Collections;
import java.util.List;
import lotto.type.Rank;

public class SystemMessage {
    public static void purchaseQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void winningHistory(List<Rank> lottosRank) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(lottosRank, Rank.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(lottosRank, Rank.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(lottosRank, Rank.THREE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(lottosRank, Rank.TWO) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(lottosRank, Rank.ONE) + "개");
    }

    public static void portfolio(double portfolio) {
        System.out.println("총 수익률은 " + String.format("%.1f", portfolio) + "%입니다.");
    }

    public static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
