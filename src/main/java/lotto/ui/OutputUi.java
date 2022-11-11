package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputUi {

    private static final String INSERT_MONEY_INFO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT = "\n%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_INFO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_INFO_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WIN_LOTTO_STATISTICS_INFO_MESSAGE = "\n당첨 통계\n---";


    public static void printInsertMoneyInfoMessage() {
        System.out.println(INSERT_MONEY_INFO_MESSAGE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {

        System.out.println(String.format(PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT, lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printInputWinningNumbersInfoMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_INFO_MESSAGE);
    }

    public static void printInputBonusNumberInfoMessage() {
        System.out.println(INPUT_BONUS_NUMBER_INFO_MESSAGE);
    }

    public static void printWinLottoStatistic(Map<WinningRank, Integer> winLottoCount) {
        System.out.println(WIN_LOTTO_STATISTICS_INFO_MESSAGE);

        String statisticReport = generateWinStatisticReport(winLottoCount);
        System.out.println(statisticReport);
    }

    private static String generateWinStatisticReport(Map<WinningRank, Integer> winLottoCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for(WinningRank rank : WinningRank.values()){
            if(rank.getPrizeMoney() != 0){
                stringBuilder.append(rank.toString());
                stringBuilder.append(" - ");
                stringBuilder.append(winLottoCount.getOrDefault(rank, 0));
                stringBuilder.append("개\n");
            }
        }
        return stringBuilder.toString();
    }

}
