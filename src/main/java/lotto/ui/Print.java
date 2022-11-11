package lotto.ui;

import java.util.List;
import lotto.Lotto;

public class Print {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String USER_LOTTO_PAY_COUNT = "개 구매했습니다.";
    private static final String PRINT_WIN_STATS_START_TEXT = "당첨 통계\n---";
    private static final String WIN_STATS_SAME_TEXT = "개 일치";


    public void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void printInputWinLottoNumber() {
        System.out.println(INPUT_WIN_LOTTO_NUMBER);
    }

    public void printInputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printLottoNumberList(List<Lotto> lottos) {
        System.out.println(String.format("%s" + USER_LOTTO_PAY_COUNT, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinLottoStats(List<Lotto> lottos, int winRate) {
        System.out.println(PRINT_WIN_STATS_START_TEXT);
        // TODO n개 일치하는지 따로 score 클래스로 저장해둘지 고민해보기
        System.out.println(String.format("총 수익률은 %s%입니다.", winRate));
    }
}
