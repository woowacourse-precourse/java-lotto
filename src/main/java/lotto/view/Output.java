package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class Output {

    private static final String ERROR_TAG = "[ERROR] ";

    public static void purchaseLotto(Integer lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printYield(Long amount, Money money) {
        double yield = Math.round(((amount / (double) money.getMoney()) * 1000)) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public static void printLottoResult(LottoResult lottoResult, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        HashMap<Rank, Integer> result = lottoResult.getResult();
        Long amount = 0L;
        for (int ranking = 4; ranking >= 0; ranking--) {
            Rank rank = Rank.values()[ranking];
            System.out.printf(rank.toString() + "%d개\n", result.get(rank));
            amount += result.get(rank) * rank.getPrize();
        }
        Output.printYield(amount, money);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_TAG + message);
    }
}
