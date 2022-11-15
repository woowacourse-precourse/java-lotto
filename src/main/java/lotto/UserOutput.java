package lotto;

import java.util.List;

public class UserOutput {
    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨통계\n---";
    private static final String WINNING_STATS_DETAIL_MESSAGE = "%s - %d개";
    private static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f %%입니다.";

    public static void printLottoCount(int count){
        System.out.println(count+BUY_LOTTO_COUNT_MESSAGE);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
}
