package lotto.view;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.model.Rank.findIntroMessageWithRank;
import static lotto.model.Rank.getRankOrder;
import static lotto.utils.NumberAdapter.fitPaidMoney;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String SHOW_CUSTOMER_RANKS_MESSAGE = "당첨 통계\n---";
    private static final String HYPHEN_WITH_UNIT = " - %d개\n";
    private static final String SHOW_RATE_OF_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public OutputView() {
    }

    public void showLottos(String lottos) {
        System.out.println(lottos);
    }

    public void showLottoCount(String paidMoney) {
        System.out.println(fitPaidMoney(paidMoney) / LOTTO_PRICE + LOTTO_COUNT_MESSAGE);
    }

    public void showCustomerRanks(Map<Rank, Integer> customerRank) {
        System.out.println(SHOW_CUSTOMER_RANKS_MESSAGE);

        List<Rank> rankOrder = getRankOrder();

        for (Rank rank : rankOrder) {
            System.out.print(findIntroMessageWithRank(rank));
            System.out.printf(HYPHEN_WITH_UNIT, customerRank.get(rank));
        }
    }

    public void showRateOfProfit(float rateOfProfit) {
        System.out.printf(SHOW_RATE_OF_PROFIT_MESSAGE, rateOfProfit);
    }
}
