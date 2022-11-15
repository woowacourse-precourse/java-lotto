package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() throws IllegalArgumentException {
        long money = inputMoney();
        List<Lotto> lottos = LottoStore.getInstance().buy(money);
        showLottos(lottos);

        RankCounter rankCounter = new RankCounter();
        rankCounter.count(lottos);

        rankCounter.showRankCount();
        showEarningRate(money, rankCounter.getTotalReword());
    }

    private static long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money;
        try {
            money = Long.parseLong(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return money;
    }

    private static void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private static void showEarningRate(long spend, long earn) {
        double earningRate = (double)earn / spend * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
