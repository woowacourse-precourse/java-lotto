package lotto.view.outputView;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputViewImple implements OutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATUS_ANNOUNCEMENT_MAESSAGE = "당첨 통계\n" +
            "---";
    private static final String WINNING_STATUS_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_STATUS_SECOND_RANK_CASE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MONEY_PATTERN = "###,###";
    private static final String RETURN_RATIO_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    @Override
    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedAmount(lottos);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private void printPurchasedAmount(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, lottos.size()));
    }

    @Override
    public void printWinningStatus(Map<Rank, Integer> winningStatus) {

        System.out.println(WINNING_STATUS_ANNOUNCEMENT_MAESSAGE);

        for (Rank rank : winningStatus.keySet()) {

            if (rank.equals(Rank.ZERO_MATCH)) continue;

            System.out.println(String.format(createWinningStatusFormatBy(rank)
                    , Rank.getMatchedCountFor(rank)
                    , convertPrizeToMoneyFormat(Rank.getRankPrize(rank))
                    , winningStatus.get(rank)));
        }
    }

    private String createWinningStatusFormatBy(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return WINNING_STATUS_SECOND_RANK_CASE_MESSAGE;
        }
        return WINNING_STATUS_MESSAGE;
    }

    private String convertPrizeToMoneyFormat(Integer prize) {
        return new DecimalFormat(MONEY_PATTERN).format(prize);
    }


    @Override
    public void printReturnRatio(double returnRatio) {
        System.out.println(String.format(RETURN_RATIO_MESSAGE, returnRatio));
    }

    @Override
    public void printErrorMessage(Exception e) {
        System.out.println(String.format(ERROR_MESSAGE, e.getMessage()));
    }


}
