package lotto.view;

import lotto.controller.Result;
import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.List;
import java.util.Map;

import static lotto.domain.Win.*;

public class Messages {
    // Inputs
    public static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    public static final String ASK_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Results
    private static final String RESULT_BUY_LOTTO = "개를 구매했습니다.";
    private static final String RESULT_LOTTO_WIN = "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n" +
            "총 수익률은 %.1f%%입니다.";

    /** 로또 구입 개수 메시지 반환 메서드 */
    public static final String PRINT_BUY_LOTTO (int lotto) {
        return "\n"+lotto+RESULT_BUY_LOTTO;
    }

    private static final String PRINT_LOTTO (Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    /** 로또 구입 결과 메시지 반환 메서드 */
    public static final String PRINT_LOTTOS (List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos) {
            sb.append(Messages.PRINT_LOTTO(lotto)+"\n");
        }
        return String.valueOf(sb);
    }

    /** 로또 결과 출력 메시지 반환 메서드 */
    public static final String PRINT_RESULT (Map<Win, Integer> wins, double winningsRate) {
        String result = String.format(RESULT_LOTTO_WIN, wins.get(FIFTH), wins.get(FOURTH), wins.get(THIRD), wins.get(SECOND), wins.get(FIRST), winningsRate);
        return result;
    }
}
