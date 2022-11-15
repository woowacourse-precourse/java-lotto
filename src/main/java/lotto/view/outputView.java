package lotto.view;

import static lotto.domain.SystemMessage.WINNING_STATISTICS_MESSAGE;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinningRank;


public class outputView {

    private static final String WINNING_DETAIL_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_DETAIL_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private enum Message {
        NUMBER_OF_LOTTO("%d개를 구매했습니다.");
        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static void printLottoGroup(LottoGroup lottos, Integer numOfLotto) {
        System.out.println(String.format(Message.NUMBER_OF_LOTTO.getValue(), numOfLotto));
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

    public static void printWinningMessage(){
        System.out.printf(WINNING_STATISTICS_MESSAGE);
    }
}
