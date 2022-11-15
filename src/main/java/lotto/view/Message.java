package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;

import java.text.NumberFormat;
import java.util.List;

public class Message {
    private static NumberFormat numberFormat = NumberFormat.getInstance();

    public static void printBuy() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLotto(User user) {
        List<Lotto> lottos = user.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream().forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public static void printWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printWinningBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResult(User user) {
        System.out.println("당첨 통계" + "\n" + "---");
        for (Rank o : Rank.values()) {
            if (o == Rank.NONE) {
                continue;
            }
            System.out.println(
                    o.getCnt() + "개 일치" + isBonus(o.isBonus()) + " (" +
                            formattingReward(o.getReward()) + "원) - " +
                            user.getResult().getOrDefault(o, 0) + "개"
            );
        }
        System.out.println("총 수익률은 " + user.calcProfit() + "%입니다.");
    }

    private static String formattingReward(int reward) {
        return numberFormat.format(reward);
    }

    private static String isBonus(boolean bonus) {
        if (bonus == true) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
