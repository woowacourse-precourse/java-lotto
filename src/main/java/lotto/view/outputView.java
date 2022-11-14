package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinningRank;


public class outputView {

    private static final String WINNING_DETAIL_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_DETAIL_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private enum Message {
        NUMBER_OF_LOTTO("개를 구매했습니다.");
        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static void printLottoGroup(LottoGroup lottos) {
        lottos.getLottoGroup().stream()
                .forEach(lotto -> System.out.println(lotto.getLotto().toString()));
        System.out.println();
    }


    public static void printWinningDetails(Map<WinningRank, Integer> winningDetails) {
        winningDetails.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningRank.NO_MATCH)
                .forEach(entry -> {
                    DecimalFormat df = new DecimalFormat("###,###");
                    if (entry.getKey() == WinningRank.FIVE_MATCH_BONUS) {
                        System.out.printf(WINNING_DETAIL_WITH_BONUS_MESSAGE,
                                entry.getKey().getMatchingCount(), df.format(entry.getKey().getWinningAmount()),
                                entry.getValue());
                        return;
                    }
                    System.out.printf(WINNING_DETAIL_MESSAGE,
                            entry.getKey().getMatchingCount(), df.format(entry.getKey().getWinningAmount()),
                            entry.getValue());
                });
    }
}
