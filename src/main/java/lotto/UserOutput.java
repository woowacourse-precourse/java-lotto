package lotto;

import java.util.List;

public class UserOutput {

    // 몇개를 구매했는지
    // 구입한 로또의 목록
    // 당첨내역 (noti, count)
    // 수익률
    private static final String BUY_LOTTO_COUNT_MSG = "개를 구매했습니다.";
    private static final String WINNING_STATS_MSG = "당첨통계\n---";
    private static final String WINNING_STATS_DETAIL_MSG = "%s - %d개";
    private static final String WINNING_RATE_MSG = "총 수익률은 %.2f %%입니다.";

    public static void printLottoCount(int count){
        System.out.println(count+BUY_LOTTO_COUNT_MSG);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


}
