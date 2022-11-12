package lotto.io;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.GameScore;
import lotto.Lotto;
import lotto.LottoWinType;

public class Print {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String USER_LOTTO_PAY_COUNT = "개를 구매했습니다.";
    private static final String PRINT_WIN_STATS_START_TEXT = "당첨 통계\n---";
    private static final String PRINT_WIN_STATS_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_WIN_STATS_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_WIN_STATS_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_WIN_STATS_FOURTH = "4개 일치 (50,000원) - ";
    private static final String PRINT_WIN_STATS_FIFTH = "3개 일치 (5,000원) - ";
    private static final String WIN_STATS_COUNT_TEXT = "개";
    private static final String PROFIT_RATE_TEXT = "총 수익률은 %.1f%%입니다.";


    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printInputWinLottoNumber() {
        System.out.println(INPUT_WIN_LOTTO_NUMBER);
    }

    public static void printInputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printLottoNumberList(List<Lotto> lottos) {
        System.out.println(String.format("%s" + USER_LOTTO_PAY_COUNT, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinLottoStats(GameScore gameScore) {
        System.out.println(PRINT_WIN_STATS_START_TEXT);
        List<LottoWinType> mapKeySet = new ArrayList<> (gameScore.getLottoWinType().keySet());
        mapKeySet.sort(Comparator.comparing(LottoWinType::getIdx));
        for (LottoWinType winType : mapKeySet) {
            if (winType == LottoWinType.ELSE) {
                continue;
            }
            System.out.println(getWinTypePrintText(winType) + gameScore.getLottoWinType().get(winType) + WIN_STATS_COUNT_TEXT);
        }
        System.out.println(String.format(PROFIT_RATE_TEXT, gameScore.getProfitRate()));
    }

    private static String getWinTypePrintText(LottoWinType winType) {
        if (winType == LottoWinType.FIRST_PLACE) {
            return PRINT_WIN_STATS_FIRST;
        }

        if (winType == LottoWinType.SECOND_PLACE) {
            return PRINT_WIN_STATS_SECOND;
        }

        if (winType == LottoWinType.THIRD_PLACE) {
            return PRINT_WIN_STATS_THIRD;
        }

        if (winType == LottoWinType.FOURTH_PLACE) {
            return PRINT_WIN_STATS_FOURTH;
        }

        if (winType == LottoWinType.FIFTH_PLACE) {
            return PRINT_WIN_STATS_FIFTH;
        }
        return "";
    }
}
